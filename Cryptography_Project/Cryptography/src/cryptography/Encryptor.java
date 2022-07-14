package cryptography;
import java.io.*;

public class Encryptor 
{
    KeyGenerator kGen;
    
    public Encryptor(String key) 
    {
        //get the KeyGenerator
        kGen = new KeyGenerator(key);
    }
    
    public void encrypt(String src, String trgt)throws Exception //throws statement is used to explicitly propogate a Checked Exception
    {
        //open the source file for reading
        //file must exist, otherwise FileNotFoundException be raised
        FileInputStream fin = new FileInputStream(src);
        //RandomAccessFile fin = new RandomAccessFile(src, "r");
        
        //fin = open(src, "rb")
        
        //open the target file for writing
        //file will be created or overwritten
        //Invalid path or permission issue may cause FileNotFoundException 
        FileOutputStream fout = new FileOutputStream(trgt);
        //fout = open(trgt, "wb")
        
        String nK = kGen.getNumericKey();
        
        //for level 1 of encryption
        ArmstrongManager aManager = new ArmstrongManager(nK);
        //for level 2 of encryption
        ColorManager cManager = new ColorManager(nK);
        
        byte buffer[] = new byte[2048];
        int n, i;
        int temp;
        
        while((n = fin.read(buffer)) != -1)
        {
            // It is used to read up to buffer.length bytes of data from the input stream.
            //process the buffer
            for (i =0 ; i < n; i++)
            {
                temp = aManager.encrypt(buffer[i] & 0xFF);
                temp = cManager.encrypt(temp);
                buffer[i] = (byte)temp;
            }
            //write into the result
            fout.write(buffer, 0, n);
        }
        
        //close the files
        fin.close();
        fout.close();
        
    }
}

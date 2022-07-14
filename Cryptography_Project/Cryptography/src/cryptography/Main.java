package cryptography;

public class Main 
{
    //entry point into the application
    public static void main(String[] args) 
    {
        /*
        String data = "This is a very important statement.";
        String key = "How old is my computer?";
        KeyGenerator kGen = new KeyGenerator(key);
        String nK = kGen.getNumericKey();
        
        ArmstrongManager aMgr = new ArmstrongManager(nK);
        ColorManager cMgr = new ColorManager(nK);
        
        String encData ="";
        int temp;
        int i;
        for(i =0 ; i < data.length(); i++)
        {
            temp = aMgr.encrypt(data.charAt(i));
            temp = cMgr.encrypt(temp);
            encData = encData  + (char)temp;
        }
        
        String decData= "";
        for(i =0 ; i < encData.length(); i++)
        {
            temp = cMgr.decrypt(encData.charAt(i));
            temp = aMgr.decrypt(temp);
            
            decData = decData  + (char)temp;
        }
        
        
        System.out.println("data: "+ data + "  " + data.length());
        System.out.println("enc data: "+ encData + "  " + encData.length());
        System.out.println("dec data: "+ decData + "  " + decData.length());
        */
        
        try
        {
            //String src = "d:/a.txt";//images/kids.jpg";
            //String enc = "d:/e_a.txt";//images/e_kids.jpg";
            //String dec = "d:/d_a.txt";//images/d_kids.jpg";
            String src = "G:\\Study stuff\\projects\\src.txt";
            String enc = "G:\\Study stuff\\projects\\enc.txt";
            String dec = "G:\\Study stuff\\projects\\trgt.txt";
            
            //String src = "G:\Study stuff\projects\\Roses.mp3";
            //String enc = "G:\Study stuff\projects\\encc.mp3";
            //String dec = "G:\Study stuff\projects\\trgtt.mp3";

            String key = "My Name Is Aarti Rathi";

            Encryptor objEnc = new Encryptor(key);
            Decryptor objDec = new Decryptor(key);

            objEnc.encrypt(src, enc);
            System.out.println("Encryption Done on "+ src + "\n\nEncrypted file is "+enc);
            
            objDec.decrypt(enc, dec);
            System.out.println("\nDecryption Done! \n" + "\nDecrypted file is " +dec);
        

        }
        catch(Exception ex)
        {
            System.out.println("Err: " +ex.getMessage());
        }
        
    }
    
}

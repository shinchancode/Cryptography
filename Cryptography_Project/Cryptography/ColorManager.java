package cryptography;
//encryption - decryption : grade 2
class ColorManager 
{
    private int rgb[];
    private int enc_index, dec_index;
    
    ColorManager(String nK) 
    {
        rgb = new int[3];
        enc_index = dec_index = -1;
        
        int partB = Integer.parseInt(nK.substring(12));//int(nK[12:])
        rgb[0] = (Integer.parseInt(nK.substring(0, 4)) + partB)%256; //int(nK[0:4])
        rgb[1] = (Integer.parseInt(nK.substring(4, 8)) + partB)%256; //int(nK[4:8])
        rgb[2] = (Integer.parseInt(nK.substring(8, 12)) + partB)%256; //int(nK[8:12])
    }

    int encrypt(int data)
    {
        int nibbles[] = ByteManager.byteToNibble(data);
        enc_index = (enc_index+1)%rgb.length;
        return (rgb[enc_index]+ nibbles[0] * 16 + nibbles[1])%256;
    }
    
    
    
    int decrypt(int data)
    {
        int temp;
        int nibbles [] = new int[2];
        dec_index = (dec_index + 1) % rgb.length;
        temp = (data - rgb[dec_index] + 256) % 256;
        
        nibbles[0] = temp/16;
        nibbles[1] = temp%16;
        return ByteManager.nibblesToByte(nibbles);
        
    }
}

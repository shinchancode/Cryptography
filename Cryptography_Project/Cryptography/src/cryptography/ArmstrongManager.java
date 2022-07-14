package cryptography;
//encryption - decryption : grade 1

class ArmstrongManager 
{
    private String numericKey;
    private int enc_index, dec_index;
    
    ArmstrongManager(String nK) 
    {
        numericKey = nK;
        enc_index = -1;
        dec_index = -1;
    }

    //python equivalent for the constructor above
    //def __init__(self, nK): 
    //    self.__numericKey__ = nK
    //    self.__enc_index__ = -1
    //    self.__dec_index__ = -1
    
    int encrypt(int data)
    {
        try
        {    
            return data ^ numericKey.charAt(++enc_index);
        }
        catch(StringIndexOutOfBoundsException ex)
        {
            enc_index = -1;
            return data ^ numericKey.charAt(++enc_index);
        }
    }


    int decrypt(int data)
    {
        try
        {    
            return data ^ numericKey.charAt(++dec_index);
        }
        catch(StringIndexOutOfBoundsException ex)
        {
            dec_index = -1;
            return data ^ numericKey.charAt(++dec_index);
        }
    }
    
}

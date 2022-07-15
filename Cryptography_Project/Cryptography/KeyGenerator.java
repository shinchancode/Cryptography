package cryptography;

/*
Uses the permutation and combination of armsrtong 
numbers to generate a numeric key from string input.
*/

class KeyGenerator 
{
    //private : for internal use of this class only
    //static data : one allocation for all the objects of the class 
    private static int armstrongNumbers[]= {153, 370, 371, 407};
    private static int baseTable[]= {1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321};
    
    //non static:
    //data belongs to the object of the class
    private String key, numericKey;
    

    //constructor:
    //A special member of the class, that resemebles a method but has a special signature.
    //It is an initializer for the objects of the class.
    //It is auto invoked as object of the class is created.
    
    //FYI: if a constructor is applied a return type
    //then it converts into a method.

    KeyGenerator(String k) 
    {
        //this reference of Java == self reference of Python
        //this is implicitly declared and used.
        this.key = k;
        this.numericKey = "";
    }
    
    String getNumericKey()
    {
        if(numericKey.equals(""))
            generateNumericKey();
        
        return numericKey;
    }
    
    private void generateNumericKey()
    {//key: How old is my computer?
        
        int tot = 0;
        int l, i;
        l = key.length();
        for(i =0; i < l; i++)
        {//add the ASCII of characters of key
            
            tot += key.charAt(i);
            //python: tot += ord(key[i])
        }
        //example : tot = 2141
        
        int permutation = baseTable[tot % baseTable.length];
        //example : permutation = baseTable[5] = 1432
        
        String temp= "";
        //System.out.println("***"  + permutation);
        while(permutation > 0)
        {
            temp =  armstrongNumbers[permutation % 10 -1] + temp;
            permutation /= 10; 
        }
        //numericKey = partA+partB
        numericKey = temp + tot;
    }
    
    void display()
    {
        System.out.println("key " + key);
        System.out.println("numeric key " + numericKey);
    }
}

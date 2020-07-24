package app;

/**
 *
 * @author
 */
public class Decoder {
    
    public static String decodeString(String watermark )
    {
        System.out.println(watermark);
      
        String watermarkAscii =""; 
        
        int size = 3;        
        
        for(int i = 0 ; i < watermark.length() ; i+=size)
        {
            String subkata = watermark.substring(i, i+size); 
        
            int kataASCII = cekKodeDecode(Integer.parseInt(subkata)); 
            
            watermarkAscii +=   (char)kataASCII;
        }
        
        return watermarkAscii;
    }
    /*
    Decode the numbers based on Final Task document
    */
    public static int cekKodeDecode(int ascii)
    {
        if(decodeAsciiSeratus(ascii))
        {
            ascii = 100;
        }
        else if(decodeAsciiLebihSeratus(ascii))
        {
            ascii-=10;
        }
        else if(decodeAsciiDuaAngka(ascii))
        {
            ascii-=200;
        }else if(decodeAsciiHabisModSepuluh(ascii))
        {
            ascii-=301;
        }
        return ascii;
    }
    private static boolean decodeAsciiSeratus(int ascii)
    {
        if(ascii == 138)
        {
            return true;
        }
        return false;
    }
    private static boolean decodeAsciiLebihSeratus(int ascii)
    {
        if(ascii > 100 && ascii <200 && ascii%10 != 0)
        {
            return true;
        }
        return false;
    }
    private static boolean decodeAsciiDuaAngka(int ascii)
    {
        if(ascii > 200 &&  ascii < 300)
        {
            return true;
        }
        return false;
    }
    private static boolean decodeAsciiHabisModSepuluh(int ascii)
    {
        if(ascii > 300)
        {
            return true;
        }
        return false;
    }
}

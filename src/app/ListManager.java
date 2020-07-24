/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;

/**
 *
 * @author
 */
public class ListManager {
    
      /*
    Get all string from a list
    */
    public static String getStringFromList(List<String> list)
    {
        StringBuilder stringBuffer = new  StringBuilder();         
      
        for(String text: list){
        
            stringBuffer.append(text +"\n");
        
        }
        
        return stringBuffer.toString();
    }
    
}

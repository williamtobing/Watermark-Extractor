package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javafx.stage.FileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
public class FileManager {
    
    static String fileName;
    /**
     * Using static so that this class not to be instantiate 
     * Opening the browser file then choose the file
     * @return File 
     */
    public static File getUploadedFile()
    {
        FileChooser fileChooser = new FileChooser();
 
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        
        fileChooser.getExtensionFilters().add(extFilter); 
        
        File file = fileChooser.showOpenDialog(null);
        
        return file;
    }
    public static void setFileName(File file)
    {
        fileName = file.getName();
    }
    public static String getFileName()
    {
        return fileName;
    }
    /**
     *     Read the uploaded file(.txt) then store the string to a list 
     * @param file
     * @param listEdge
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public List<String> readFileAndGetTheList(File file, List<String> listEdge) throws FileNotFoundException, IOException
    {
        StringBuilder stringBuffer = new  StringBuilder();
       
        BufferedReader bufferedReader = null;   
        
        bufferedReader = new BufferedReader(new FileReader(file));
        
        String text;      
        
        while ((text = bufferedReader.readLine()) != null) {
        
            stringBuffer.append(text +"\n");
            
            insertToList(text, listEdge);
        }     
         return listEdge;
    } 
     /**
      * Insert a string to a list
      * @param text
      * @param listEdge 
      */
    
    private void insertToList(String text, List<String> listEdge)
    {
        listEdge.add(text);
    } 
}

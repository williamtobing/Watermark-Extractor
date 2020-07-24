/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author
 */ 

public class Watermark {
    public static String nama_watermark;
    
    public Watermark(String watermark){
        nama_watermark = watermark;
    }
   /**
    *     Get the watermark from the adjacency list change it become ASCII and then decode it 
    * @param adjList
    * @param panjangListAdj
    * @return 
    */
    public static String getWatermark(LinkedList<Integer> adjList[], int panjangListAdj)
    {
        nama_watermark = Hasil.getASCIIFromAdjacencyList(adjList, panjangListAdj);
        
        nama_watermark = Decoder.decodeString(nama_watermark);
        
        return nama_watermark;
    }
}

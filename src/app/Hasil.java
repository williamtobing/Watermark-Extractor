package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author
 */
public class Hasil 
{ 
    /*
        Build watermark series of number from adjacency list 
    */
    public static String getASCIIFromAdjacencyList(LinkedList<Integer> adj[], int limitpanjanglist)
    {
      String watermark = "";  
      
      for(int i = 0 ; i < limitpanjanglist+1 ; i++)
      {
          if(adj[i].size() > 0)
          {
              watermark+= Integer.toString(adj[i].size()); 
          }

      } 
      return watermark;
    }
    public static String getWatermark(List<String> listEdge){

        Graph graph = new Graph();

        LinkedList<Integer> adjList[];

        int maxVertex= graph.getMaxVertex(listEdge); 

        graph.clearAdjacencyList(maxVertex);

        graph.insertEdgeToAdjacencyList(listEdge);

        adjList = graph.getAdjacencyList();

        String watermark = Watermark.getWatermark(adjList, maxVertex);

        return watermark;
    }
     public static String getGraphBuilder(List<String> listEdge){
        
        String graphBuilder = ListManager.getStringFromList(listEdge);
        
        return graphBuilder;
    }
}
 
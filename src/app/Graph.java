 package app;

/**
 *
 * @author
 */
 
import java.util.*; 
 
public class Graph 
{ 
	private static int a_size = 10000; // No. of vertices 
 
        private static LinkedList<Integer> adj[]; //Adjacency Lists 

        /**
         * Create Adjacency List with size a_size
         */
	public Graph() 
	{ 

            adj = new LinkedList[a_size]; 
         
            for (int i=0; i<a_size; ++i) 
            
                adj[i] = new LinkedList(); 
	}  

  
        /*
            Processing String example 1 2. Split the string become 2 numbers become the first vertice 
            and the second vertice. Those two vertices become connected edge. Then store this 2
            vertices to adjacency list
        */
        public  void addEdge(String edgeAngka)
        {
            String[] arrOfStr = edgeAngka.split(" "); 

            int v1 = Integer.parseInt(arrOfStr[0]);

            int v2 = Integer.parseInt(arrOfStr[1]);

            adj[v1].add(v2);      
        }

	/**
         *  Return processing adjacency list
         * @return 
         */
        public LinkedList<Integer> [] getAdjacencyList()
        {            
            return adj;
        }
        /**
         * Clear the adjacency List for remove duplicates value
         * @param max 
         */
        public void clearAdjacencyList(int max){
          
            for(int  i= 0; i<= max ;i++){
            
                for(Integer a: adj[i]){
                 
                     adj[i].clear();
                }
            }
        }
      /**
       * Insert a line of text from list become edge in adjacencyList
       * @param listEdge 
       */
        public void insertEdgeToAdjacencyList(List<String> listEdge){
           
            StringBuilder stringBuffer = new  StringBuilder();
         
            int maxVertex = 0;
            
            for(String text: listEdge )
            {
                addEdge(text);
            }

        }
      
        public int getMaxVertex(List<String> listEdge)
        {
            StringBuilder stringBuffer = new  StringBuilder();
           
            int maxVertex = 0;
            
            for(String text: listEdge )
            {
                stringBuffer.append(text +"\n");
              //  addEdge(text);
                maxVertex = getMaxNumber(text, maxVertex); 
            }
            return maxVertex;
        }
      
        private int getMaxNumber(String text, int maxVertex)
        {
          String[] arrOfStr = text.split(" ");
      
          int angka = Integer.parseInt(arrOfStr[0]);
          
          int maxi = Math.max(angka, maxVertex);
          
          return maxi;
        }

} 
  

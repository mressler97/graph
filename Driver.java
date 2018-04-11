import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
	public static void main(String [] args) {
		 int vertices = 0;
	 	int dist[][] = new int[vertices][vertices];
	 
	 	 
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt")))
        {
        int linenumber = 0;
       
        String newLine;
   
       
        //	int[][] dataDetail2;
            
            while ((newLine = br.readLine()) != null) 
            {
                //System.out.println(newLine);
                linenumber++; 
                
                if(linenumber==1) {
                String[] dataDetails = newLine.split(",");

                for(int i=0; i<dataDetails.length; i++) {
                	vertices++;
               
                }
            	System.out.println(vertices);
            	System.out.println();
             
                }
                else {
                	 String[] dataDetail = newLine.split(",");
                	 if(dataDetail.length > 0 ) {
                	 //System.arraycopy(dataDetail,0,dataDetail2,0,1);
                		 
                		 for(int i=0; i< vertices; i++) {
                			 for(int j=0; j<vertices; j++) {
                				for(int k=0; k<dataDetail.length; k++) {
                					 dist[i][j] = Integer.parseInt(dataDetail[k]);
                		                    	 
                		                     }
                			 }
                		 }
                	
                     		//floydMarshall(graph);
                         //Pair data = new Pair(Integer.parseInt(dataDetails[0]), dataDetails[1]);
                     }
                }
            }
            br.close();
        }catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
		
		 for(int i=1; i<= dist.length; i++) {
			 for(int j=1; j<=dist[i].length; j++) {
				 System.out.println(dist[i][j] + " ");
			 }
			 System.out.println();
			 }
		 
                 
                 
        //Prim algorithim initiation
        PrimMST p = new PrimMST();
        p.prim(dist);
        //NEED varibale for the graph
	}
	
}
/*
for(int i=0; i<dataDetails.length; i++) {
	 for( int j=0; j<dataDetails.length; j++) {
			dataDetails[i] = dist[i][j];
	 }
	 */


class PrimMST {

    int vertices = 5;
    
    //finding the min key value
    int minimumKey(int key[], Boolean minTreeSet[]){
        int min = Integer.MAX_VALUE, min_index=-1;
        for (int a = 0; a < vertices; a++) 
            if (minTreeSet[a] == false && key[a] < min)
            {
                min = key[a];
                min_index = a;
            }
        return min_index;
}
    
    void printMinTree(int p[], int n, int graph[][]){//prints the tree weights and edges
        System.out.print("Edge Weight");
        for (int i = 1; i < vertices; i++){
            System.out.println(p[i]+ " - " + i + "    "+ graph[i][p[i]]);
        }
    }
    
    void prim(int graph[][]){
        int p[] = new int[vertices];
        int key[] = new int[vertices];
        Boolean minTreeSet[] = new Boolean[vertices];
        
        for (int i = 0; i < vertices; i++){
            key[i] = Integer.MAX_VALUE;
            minTreeSet[i] = false;
        }
        
        key[0] = 0;
        p[0] = -1;
        
        for (int count = 0; count< vertices-1; count++){
            int m = minimumKey(key, minTreeSet);
            minTreeSet[m] = true;
            
            for (int v = 0; v < vertices; v++){
                if (graph[m][v] != 0 && minTreeSet[v] == false && graph[m][v] < key[v]){
                    p[v] = m;
                    key[v] = graph[m][v];
                }
            }
        }
        
        printMinTree(p, vertices, graph);
    }
}
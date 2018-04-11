/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg3.pkg232;

/**
 *
 * @author lhill
 */

import java.util.*;
import java.lang*;
import java.io*;

public class PrimMST {

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

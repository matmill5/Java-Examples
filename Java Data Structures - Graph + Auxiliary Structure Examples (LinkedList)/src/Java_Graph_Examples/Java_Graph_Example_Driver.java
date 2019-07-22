/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Graph_Examples;

import java.util.Random;

/**
 *
 * @author Matthew
 */
public class Java_Graph_Example_Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int V = 100000; //100,000 vertices
        Graph graph = new Graph(V); //Initialize 100,000 node graph
        //Loop through and create between 1-5 random connections.  Graph may be disconnected, but not always.
        for(int i = 0; i < V; i++){
           Graph.addEdge(graph, i, rand.nextInt(V));
        }
        // print the adjacency list representation of
        Graph.printGraph(graph);
        System.out.println("\nBFS:");
        graph.BFS(0, 8);
        System.out.println("\nDFS:");
        graph.dfs(0, 8);
        //graph.dijkstra(graph, 3); //Doesn't work.
    }
}

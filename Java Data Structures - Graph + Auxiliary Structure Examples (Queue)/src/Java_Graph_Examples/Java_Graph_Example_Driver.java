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
        int n = 10;
        SimpleGraph aSimpleGraph = new SimpleGraph(n);
        Random rand = new Random();
        for(int i = 0; i < n; i++){ //Insert a vertex with random number(1,300000)
            aSimpleGraph.insertVertex(i, new ListingA9(i, (rand.nextInt(30000) + 1)));
        }
        while(aSimpleGraph.verifyOneToFiveConnect(n) != true){
            aSimpleGraph.insertEdge(rand.nextInt(n), rand.nextInt(n));
        }
        for(int i = 0; i < n; i++){
            aSimpleGraph.showEdges(i);
        }
        for(int i = 0; i < n; i++){
            System.out.println(aSimpleGraph.getVertex(i).getConnections());
        }
        BFS(aSimpleGraph, 0, 12301);
    }
    // prints BFS traversal from a given source s 
    static void BFS(SimpleGraph aGraph, int i, int numberToLookFor) {  
	
        // Create a queue for BFS 
	Queue aQueue = new Queue(100); 
        
        // Mark the current node as visited and enqueue it
        if(aGraph.getVertex(i).getRandNumber() == numberToLookFor){
            System.out.println("Found " + numberToLookFor + "at node" + i);
            System.exit(1);
        }
	aQueue.enqueue(aGraph.getVertex(i));
        aGraph.getVertex(i).setSearch(true);
        
        ListingA9 v;
        int counter = 0;
	while (aQueue.isEmpty() == false) 
        { 
            counter = counter + 1;
            // Dequeue a vertex from queue and print it 
            v = aQueue.dequeue(); 
            System.out.print(v + " " + counter); 
            //Process all neights of v
            int[] neighborsIndexs = aGraph.getNeightbors(v.getVertexNumber());
            for(int z = 0; z < neighborsIndexs.length; z++){
                if(aGraph.getVertex(neighborsIndexs[z]).getSearch() == false){
                    aQueue.enqueue(aGraph.getVertex(neighborsIndexs[z]));
                    aGraph.getVertex(neighborsIndexs[z]).setSearch(true);
                }
                if(aGraph.getVertex(i).getRandNumber() == numberToLookFor){
                    System.out.println("Found " + numberToLookFor + "at node" + i);
                    System.exit(1);
                }
            }
        } 
    } 
}

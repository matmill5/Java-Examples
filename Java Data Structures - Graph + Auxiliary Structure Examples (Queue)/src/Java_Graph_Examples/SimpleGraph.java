/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Graph_Examples;

/**
 *
 * @author Matthew
 */
public class SimpleGraph {
    ListingA9 vertex[]; //The reference to the vertex array
    int edge[][]; //The reference to the edge array
    int max, numberOfVertices; //Reference to the adjancency matrix array
    
    public SimpleGraph(int n){
        vertex = new ListingA9[n]; //Allocation of the vertex array
        edge = new int[n][n];  //Allocation of the edge array
        max = n;
        numberOfVertices = 0;
    }
    public boolean insertVertex(int vertexNumber, ListingA9 newListing){
        newListing.setVertexNumber(vertexNumber);
        if(vertexNumber >= max) //The graph is full
            return false;
        vertex[vertexNumber] = newListing.deepCopy();
        numberOfVertices++;
        return true;
    }
    public boolean insertEdge(int fromVertex, int toVertex){
            if(vertex[fromVertex].getConnections() >= 5 || vertex[toVertex].getConnections() >= 5){
                return false;
            }
            else if(vertex[fromVertex] == null || vertex[toVertex] == null){
                return false;
            } else{
                edge[fromVertex][toVertex] = 1;
                vertex[fromVertex].incrementConnections(); //Ensure that each node only have between 1 and 5 connections
                vertex[toVertex].incrementConnections();  //Ensure that each node only have between 1 and 5 connections
                return true;
            }
    }
    public void showVertex(int vertexNumber){
        System.out.println(vertex[vertexNumber]);
    }
    public void showEdges(int vertexNumber){
        for(int column = 0; column < numberOfVertices; column++){
            if(edge[vertexNumber][column] == 1)
                System.out.println(vertexNumber + "," + column);
        }
    }
    public int[] getNeightbors(int vertexNumber){
        int[] result = new int[5];
        int i = 0;
        for(int column = 0; column < numberOfVertices; column++){
            if(edge[vertexNumber][column] == 1){
                result[i] = column;
                i++;
            }
        }
        return result;
    }
    public ListingA9 getVertex(int i){
        return vertex[i];
    }
    public int getVertexConnections(int i){
        return vertex[i].getConnections();
    }
    public boolean verifyOneToFiveConnect(int n){//This returns true if all nodes have 1-5 connections
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(vertex[i].getConnections() > 0){
                counter = counter + 1;
            }
            if(counter == n){
                return true;
            }
        } return false;
    }
}

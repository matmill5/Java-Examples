/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Graph_Examples;

import javax.swing.JOptionPane;

/**
 *
 * @author Matthew
 */
public class ListingA9 {
    private int randomNumber;
    private int numberOfConnections;
    private int vertexNumber;
    private boolean searched;
    
    public ListingA9(int aVertexNumber, int aRandomNumber){
        randomNumber = aRandomNumber;
        numberOfConnections = 0;
        vertexNumber = aVertexNumber;
        searched = false;
    };
    @Override
    public String toString(){
        return("Number is: " + randomNumber);
    }
    public ListingA9 deepCopy(){
        ListingA9 clone = new ListingA9(vertexNumber, randomNumber);
        return clone;
    }
    public void setNumber(int aNumber){
        randomNumber = aNumber;
    }
    public void setConnections(int aNumberOfConnections){
        numberOfConnections = aNumberOfConnections;
    }
    public void setVertexNumber(int i){
        vertexNumber = i;
    }
    public void setSearch(boolean b){
        searched = b;
    }
    public boolean getSearch(){
        return searched;
    }
    public int getRandNumber(){ //This is the same as getKey()
        return randomNumber;
    }
    public int getVertexNumber(){
            return vertexNumber;
    }
    public int getConnections(){
        return numberOfConnections;
    }
    public void incrementConnections(){
        numberOfConnections = numberOfConnections + 1;
    }
    public void input(){
        randomNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter a random number"));
        numberOfConnections = Integer.parseInt(JOptionPane.showInputDialog("Enter a random number of connections"));
    }
}

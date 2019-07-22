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

public class Node {
        Random rand = new Random();
        Node(){
            id = -1;
            randNum = -1;
            connections = 0;
            weight = 0;
        }
        Node(int i){
            id = i;
            randNum = rand.nextInt(300000) + 1; //Give the node a random number between 0-300,000
            connections = 0;
            weight = rand.nextInt(100) + 1; //Weight the edges between 0-100.
        }
        void setConnections(){ //To ensure that each node only has 1-5 connections
            connections = connections + 1;
        }
        int getID(){
            return this.id;
        }
        int id;
        int randNum;
        int connections;
        int weight;
}

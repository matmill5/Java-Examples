/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Stack_and_Queue_Examples;

/**
 *
 * @author Matthew
 */
public class Stack {
    Stack(){
        height = 0; 
        array = new String[0];
    };    
    public String pop(){
        String result = array[height-1];
        height--;
        String[] tmp = new String[height];
        for(int i = 0; i < height; i++){
            tmp[i] = array[i];
        }
        array = new String[height];
        for(int i = 0; i < height; i++){
            array[i] = tmp[i];
        }
        return result; 
    };
    public void push(String item){
        if(height == 0){
            array = new String[1];
            height = height + 1;
            array[0] = item;
        } else {
            String[] tmp = new String[height];
            for(int i = 0; i < height; i++){
                tmp[i] = array[i];
            }
            height = height + 1;
            array = new String[height];
            for(int i = 0; i < (height-1); i++){
                array[i] = tmp[i];
            }
            array[(height-1)] = item;
        }
    };
    public String top(){ return array[(height-1)]; };
    public void printStack(){
        System.out.println("Printing Stack: ");
        System.out.println(height);
        for(int i = 0; i < height; i++){
            System.out.println(array[i]);
        }
    }
    public int getHeight(){return height;};
    private int height;
    private String[] array;
}

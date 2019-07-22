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
public class Queue {
    Queue(){
        array = new String[1];
        front = 0;
        rear = -1;
        capacity = 1;
        count = 0;
    };
    Queue(int size){
        array = new String[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    };
    public boolean isEmpty(){
        return(count == 0);
    };
    public boolean isFull(){
        return(count == capacity);
    };
    public int size(){
        return count;
    };
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty, cannot dequeue()");
            System.exit(1);
        } else {
            System.out.println("Removing item: " + array[front]);
            front = (front + 1) % capacity;
            count = count - 1;
        }
    };
    public void enqueue(String item){
        if(isFull()){
            System.out.println("Queue is full, cannot enqueue() ");
            System.exit(1);
        }
        
        System.out.println("Inserting item: " + item);
        
        rear = (rear + 1) % capacity;
        array[rear] = item;
        count = count + 1;
    };
    public String peek(){
        if(isEmpty()){
            System.out.println("Queue is empty, cannot peek an element");
            System.exit(1);
        }
        return array[front];
    };
    public void printQueue(){
        for(int i = 0; i < count; i++){
            System.out.println(array[i]);
        }
    }
    private String array[];
    private int front;
    private int rear;
    private int capacity;
    private int count;
}

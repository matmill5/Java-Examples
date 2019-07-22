/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Stack_and_Queue_Examples;

import java.util.Scanner;

/**
 *
 * @author Matthew
 */
public class Java_Stack_and_Queue_Examples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Demonstate Queue
        Queue aQueue = new Queue(5);
        Scanner scan = new Scanner(System.in);
        char shouldWeContinue = 'Y';
        
        while(shouldWeContinue == 'Y'){
            System.out.println("Please enter a string to enqueue(): ");
            aQueue.enqueue(scan.nextLine());
            System.out.println("Would you like to continue entering items?: ");
            shouldWeContinue = scan.nextLine().toCharArray()[0];
        }
        
        System.out.println("Printing the queue's contents: ");
        aQueue.printQueue();
        System.out.println("Demonstrating peek()");
        System.out.println(aQueue.peek());
        System.out.println("Demonstrating dequeue, x2: ");
        aQueue.dequeue();
        aQueue.dequeue();
        System.out.println("Dequeue x2 complete");
        System.out.println("The remaining contents of the queue: ");
        aQueue.printQueue();
        
        //Demonstrate Stack. 
        //If function doesn't work, place the function's contents into main.
        demonstrateStack();
    }
    
    public static void demonstrateStack(){
        Stack aStack = new Stack();
        Scanner scan = new Scanner(System.in);
        char shouldWeContinue = 'Y';
        while(shouldWeContinue == 'Y'){
            System.out.println("Enter a string to push onto the stack: ");
            String item = scan.nextLine();
            aStack.push(item);
            System.out.println("Should we continue?: ");
            shouldWeContinue = scan.nextLine().toCharArray()[0];
        }
        aStack.printStack();
        
        System.out.println("Demonstrating pop()");
        while(aStack.getHeight() != 0){
            System.out.println("This is the stack's height before pop: " + aStack.getHeight());
            String aPopItem = aStack.pop();
            System.out.println("This is the stack's height after pop: " + aStack.getHeight());
            System.out.println("This is the popItem: " + aPopItem);
        }
    }
}
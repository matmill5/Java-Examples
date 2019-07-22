/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Singly_Linked_List_Examples;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Matthew
 */
public class Java_Singly_Linked_List_Example_Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Exercise #27 driver program
        int userInput = 0;
        SinglyLinkedList aSinglyLinkedList = new SinglyLinkedList();
        String aNAME;
        int aID;
        float aGPA;
        String updNAME;
        
        while(true){
            System.out.println("Enter 1 to insert a student.\n" + "Enter 2 to fetch and output student.\n" + "Enter 3 to delete a student.\n" + "Enter 4 to update a student.\n" + "Enter 5 to output all students.\n" + "Enter 6 to quit\n");
            userInput = Integer.parseInt(JOptionPane.showInputDialog("Enter your selection: "));
            switch (userInput) {
                //Insert a new student's info
                case 1:
                {
                    System.out.println("In the insert");
                    aNAME = JOptionPane.showInputDialog("Enter a name to insert");
                    aID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
                    aGPA = Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA"));
                    aSinglyLinkedList.insert(new Listing(aNAME, aID, aGPA));
                    break;
                }
                //Fetch and output student's info
                case 2:
                {
                    System.out.println("In the fetch");
                    aNAME = JOptionPane.showInputDialog("Enter a name to fetch");
                    System.out.println(aSinglyLinkedList.fetch(aNAME).toString());
                    break;
                }
                //Delete a student
                case 3:
                {
                    System.out.println("In the delete");
                    aNAME = JOptionPane.showInputDialog("Enter a student name to delete");
                    aSinglyLinkedList.delete(aNAME);
                    break;
                }
                //Update a student's info
                case 4:
                {
                    System.out.println("In the update");
                    updNAME = JOptionPane.showInputDialog("Enter a student name to update");
                    aNAME = JOptionPane.showInputDialog("Enter a name to insert");
                    aID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
                    aGPA = Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA"));
                    aSinglyLinkedList.update(updNAME, new Listing(aNAME, aID, aGPA));
                    break;
                }
                //Output all the students
                case 5:
                {
                    System.out.println("In the output all");
                    aSinglyLinkedList.showAll();
                    break;
                }
                //Exit
                case 6:
                {
                    System.out.println("In the exit");
                    System.exit(1);
                    break;
                }
                default:
                    System.out.println("In the default");
                    break;
            }            
        }
    }
    //
    //Exercise #25 driver
    //
    public void ListingDriver(){
        // Driver program for Listing functions #25
        // Call in main() if you want to use
        String name = JOptionPane.showInputDialog("Enter a name");
        int idNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
        float gpa = Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA"));
        Listing aListing = new Listing(name, idNumber, gpa);
        System.out.println(aListing.toString());
        System.out.println("Demonstrating input() now: ");
        aListing.input();
        System.out.println("Demonstrating setName()");
        aListing.setName(JOptionPane.showInputDialog("Enter a name"));
        System.out.println("Changed Listing: " + aListing.toString());
        System.out.println("Demonstrating setID()");
        aListing.setID(Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number")));
        System.out.println("Changed Listing: " + aListing.toString());
        System.out.println("Demonstrating setGPA()");
        aListing.setGpa(Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA")));
        System.out.println("Changed Listing: " + aListing.toString());
        System.out.println("Demonstrating deepCopy()");
        System.out.println("Creating a second listing that will be deep copied: ");
        name = JOptionPane.showInputDialog("Enter a name");
        idNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
        gpa = Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA"));
        Listing bListing = new Listing(name, idNumber, gpa);
        aListing = bListing.deepCopy();
        System.out.println("aListing's content: " + aListing.toString() + "\n" + "bListing's content" + bListing.toString());
        System.out.println("They are the same because deepCopy has copied bListing's contents to aListing");
        System.out.println("Demonstrating compareTo()");
        System.out.println("Are aListing's name and bListing name the same (zero means YES): " + aListing.compareToString(bListing.getName()));
    }
    //
    //Exercise #26 Driver program
    //
    public void SinglyLinkedListDriverPlusGenericDriver(){
        //Listing Linked List Demo
        SinglyLinkedList aLinkedList =  new SinglyLinkedList();
        
        for(int i = 0; i < 5; i++){
            String name = JOptionPane.showInputDialog("Enter a name");
            int idNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
            float gpa = Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA"));
            Listing aNewListing = new Listing(name, idNumber, gpa);
            aLinkedList.insert(aNewListing);
        }
        aLinkedList.showAll();
        
        //Generic LinkedList Demo, Part 1, Integers as type.
        GenericSinglyLinkedList aGenericLinkedList = new GenericSinglyLinkedList();
        int i = 5;
        int z = 6;
        int b = 101;
        System.out.println("Inserted three integers '5,6,101': ");
        aGenericLinkedList.insert(i);
        aGenericLinkedList.insert(z);
        aGenericLinkedList.insert(b);
        System.out.println("Displaying the inserted integers now: ");
        aGenericLinkedList.showAll();
        aGenericLinkedList.delete(i);
        System.out.println("Deleted 5: ");
        System.out.println("Displaying entire remaining list: ");
        aGenericLinkedList.showAll();
        aGenericLinkedList.delete(z);
        System.out.println("Deleted 6: ");
        System.out.println("Displaying entire remaining list: ");
        aGenericLinkedList.showAll();
        aGenericLinkedList.delete(b);
        System.out.println("Deleted 101: ");
        System.out.println("Displaying entire remaining list: ");
        aGenericLinkedList.showAll();
        System.out.println("Reinserted 5 and 6 to the list");
        aGenericLinkedList.insert(i);
        aGenericLinkedList.insert(z);
        System.out.println("Fetched 5 from the list, returned this value: " + aGenericLinkedList.fetch(i));
        System.out.println("Fetched 6 from the list, returned this value: " + aGenericLinkedList.fetch(z));
        aGenericLinkedList.update(i, z);
        System.out.println("Tested update(), i is now z, no more i in the list: ");
        System.out.println("Fetched i from the list, returned this value: " + aGenericLinkedList.fetch(i));
        System.out.println("Fetched z from the list, returned this value: " + aGenericLinkedList.fetch(z));
        
        //Generic LinkedList Demo, Part 2, Strings as type.
        GenericSinglyLinkedList bGenericLinkedList = new GenericSinglyLinkedList();
        String iString = "I-String";
        String zString = "Z-String";
        String bString = "B-String";
        System.out.println("Inserted three Strings '5,6,101': ");
        bGenericLinkedList.insert(iString);
        bGenericLinkedList.insert(zString);
        bGenericLinkedList.insert(bString);
        System.out.println("Displaying the inserted Strings now: ");
        bGenericLinkedList.showAll();
        bGenericLinkedList.delete(iString);
        System.out.println("Deleted I-String: ");
        System.out.println("Displaying entire remaining list: ");
        bGenericLinkedList.showAll();
        bGenericLinkedList.delete(zString);
        System.out.println("Deleted Z-String: ");
        System.out.println("Displaying entire remaining list: ");
        bGenericLinkedList.showAll();
        bGenericLinkedList.delete(bString);
        System.out.println("Deleted B-String: ");
        System.out.println("Displaying entire remaining list: ");
        bGenericLinkedList.showAll();
        System.out.println("Reinserted I-String and Z-String to the list");
        bGenericLinkedList.insert(iString);
        bGenericLinkedList.insert(zString);
        System.out.println("Fetched I-String from the list, returned this value: " + bGenericLinkedList.fetch(iString));
        System.out.println("Fetched Z-String from the list, returned this value: " + bGenericLinkedList.fetch(zString));
        bGenericLinkedList.update(iString, zString);
        System.out.println("Tested update(), iString is now zString, no more i in the list: ");
        System.out.println("Fetched iString from the list, returned this value: " + bGenericLinkedList.fetch(iString));
        System.out.println("Fetched zString from the list, returned this value: " + bGenericLinkedList.fetch(zString));
        
        //Completion of tests
        System.out.println();
        System.out.println("That Concludes our tests and exercise #26, generic linked list works for both int and String types");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Binary_Tree_Example;

import Java_Binary_Tree_Example.BinaryTree.TreeNode;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthew
 */
public class Java_Binary_Tree_Example_Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Driver program for Listing class and its functions, Exercise #30
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
    public void BinaryTreeDriver(){
        //This drives some features of the binarySearchTree.
        BinaryTree aBinaryTree = new BinaryTree();
        Listing aListing = new Listing("Matthew Miller", 1445, (float) 3.6);
        aBinaryTree.insert(aListing);
        Listing bListing = new Listing("Mike Mikerson", 1332, (float) 3.2);
        Listing cListing = new Listing("Abby Aberson", 189, (float) 4.0);
        aBinaryTree.insert(bListing);
        aBinaryTree.insert(cListing);
        System.out.println(aBinaryTree.fetch("Matthew Miller").toString());
        System.out.println(aBinaryTree.fetch("Mike Mikerson").toString());
        System.out.println(aBinaryTree.fetch("Abby Aberson").toString());
    }
    public void ex31BinaryTreeStudentDriver(){
        //Exercise #31 driver program
        int userInput = 0;
        //Using a tree now, not the singlyLinkedList
        //SinglyLinkedList aSinglyLinkedList = new SinglyLinkedList();
        BinaryTree aBinaryTree = new BinaryTree();
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
                    aBinaryTree.insert(new Listing(aNAME, aID, aGPA)); 
                    break;
                }
                //Fetch and output student's info
                case 2:
                {
                    System.out.println("In the fetch");
                    aNAME = JOptionPane.showInputDialog("Enter a name to fetch");
                    System.out.println(aBinaryTree.fetch(aNAME).toString());
                    break;
                }
                //Delete a student
                case 3:
                {
                    System.out.println("In the delete");
                    aNAME = JOptionPane.showInputDialog("Enter a student name to delete");
                    aBinaryTree.delete(aNAME);
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
                    aBinaryTree.update(updNAME, new Listing(aNAME, aID, aGPA));
                    break;
                }
                //Output all the students
                case 5:
                {
                    System.out.println("In the output all");
                    aBinaryTree.printTree(aBinaryTree.getRoot());
                    //aBinaryTree.showAll();
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
}

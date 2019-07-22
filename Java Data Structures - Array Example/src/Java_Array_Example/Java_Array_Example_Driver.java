/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Array_Example;

import java.util.Scanner;

/**
 *
 * @author Matthew
 */
public class Java_Array_Example_Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char shouldWeContinue = 'Y';
       
        NodeArray students = new NodeArray();
        
        while(shouldWeContinue == 'Y'){
            System.out.println("Enter a students ID");
            int studentID = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter a student's first name");
            String firstName = scan.nextLine();
            System.out.println("Enter a student's last name");
            String lastName = scan.nextLine();
            System.out.println("Enter a student's major");
            String studentMajor = scan.nextLine();
            System.out.println("Enter a student's sex");
            char studentSex = scan.nextLine().toCharArray()[0];
            System.out.println("Enter a student's email");
            String studentEmail = scan.nextLine();
        
            Node aStudent = new Node(firstName, lastName, studentEmail, studentSex, studentMajor, studentID);
            students.addStudent(aStudent);
            
            System.out.println("Would you like to continue adding students?: 'Y' or 'N' ");
            shouldWeContinue = scan.nextLine().toCharArray()[0];
        }
        
        System.out.println("List of Students:");
        for(int i = 0; i < students.getLength(); i++){
            students.getStudent(i).printStudent();
        }
        System.out.println();
        
        System.out.println("Conducting a sort students demonstration now:  ");
        students.aplhaSortStudents();
        System.out.println();
        
        System.out.println("Printing out sorted students:");
        for(int i = 0; i < students.getLength(); i++){
            students.getStudent(i).printStudent();
        }
        System.out.println();
        
        System.out.println("Conducting a delete student demonstration now:  ");
        students.deleteStudent(1);
        System.out.println();
        
        System.out.println("Printing out remaining students:");
        for(int i = 0; i < students.getLength(); i++){
            students.getStudent(i).printStudent();
        }
    }
}

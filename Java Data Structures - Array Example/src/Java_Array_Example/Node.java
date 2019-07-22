/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Array_Example;

/**
 *
 * @author Matthew
 */
public class Node {
    private int id;
    private String fName;
    private String lName;
    private String major;
    private char sex;
    private String email;
    public Node(){
        id = 0;
        fName = "No";
        lName = "Name";
        major = "Student";
        sex = 'X';
        email = "@email.com";
    };
    public Node(String first, String last, String email, char sex, String major, int id) {
        this.id = id;
        this.sex = sex;
        this.major = major;
        fName = first;
        lName = last;
        this.email = email;
    }
    public String getLName(){
        return lName;
    }
    public void printStudent(){
        System.out.println(id + "," + fName + "," + lName + "," + major + "," + sex + "," + email);
    }
}

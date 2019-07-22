/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Binary_Tree_Example;

import javax.swing.JOptionPane;

/**
 *
 * @author Matthew
 */
public class Listing {
    private String name;
    private int idNumber;
    private float gpa;
    
    public Listing(String aName, int aID, float aGPA){
        name = aName;
        idNumber = aID;
        gpa = aGPA;
    };
    @Override
    public String toString(){
        return("Name is " + name + "\nID is " + idNumber + "\nNumber is " + gpa + "\n");
    }
    public Listing deepCopy(){
        Listing clone = new Listing(name, idNumber, gpa);
        return clone;
    }
    public int compareToString(String targetKey){
        return(name.compareTo(targetKey));
    }
    public void setGpa(float aGPA){
        gpa = aGPA;
    }
    public void setID(int aID){
        idNumber = aID;
    }
    public void setName(String aName){
        name = aName;
    }
    public String getName(){ //This is the same as getKey()
        return name;
    }
    public void input(){
        name = JOptionPane.showInputDialog("Enter a name");
        idNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
        gpa = Float.parseFloat(JOptionPane.showInputDialog("Enter a GPA"));
    }
}


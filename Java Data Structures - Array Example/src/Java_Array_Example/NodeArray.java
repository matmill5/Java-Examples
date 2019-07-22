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
public class NodeArray {
    private Node[] students;
    public NodeArray(){
        students = new Node[1];
        Node a = new Node();
        students[0] = a;
    };
    public NodeArray(Node aStudent){
        students = new Node[1];
        students[0] = aStudent;
    };
    public void addStudent(Node student){
        int size =  students.length;
        Node[] tmp = new Node[size + 1];
        for(int i = 0; i < size; i++){
            tmp[i] = students[i];
        }
        tmp[size] = student;
        students = new Node[size + 1];
        for(int i = 0; i < size + 1; i++){
            students[i] = tmp[i];
        }
    };
    public void deleteStudent(int index){
        int size = students.length;
        for(int i = index; i < size; i++){
            if(i != size-1){
                students[i] = students[i+1];
            } else{
                students[i] = students[size-1];
            }
        }
        Node[] tmp = new Node[size-1];
        for(int i = 0; i < size-1; i++){
            tmp[i] = students[i];
        }
        students = new Node[size-1];
        for(int i=0; i < size-1; i++){
            students[i] = tmp[i];
        }
        
        System.out.println("Student seemingly deleted");
    };
    public void aplhaSortStudents(){
        int n = students.length; 
        for (int i = 0; i < n-1; i++){
            
            for (int j = 0; j < n-i-1; j++){
                if (students[j].getLName().compareTo(students[j+1].getLName()) > 0) 
                { 
                    // swap arr[j+1] and arr[i] 
                    Node tmp = students[j]; 
                    students[j] = students[j+1]; 
                    students[j+1] = tmp; 
                }
            }
        }
        System.out.println("Students were alpha sorted");
    };
    public Node getStudent(int index){
       return students[index];
    };      
    public int getLength(){
        return students.length;
    };
}

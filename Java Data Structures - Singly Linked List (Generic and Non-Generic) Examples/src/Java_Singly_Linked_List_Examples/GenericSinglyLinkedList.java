/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Singly_Linked_List_Examples;

/**
 *
 * @author Matthew
 */
public class GenericSinglyLinkedList<T> {
    private Node header;
    public class Node{
        private T l;
        private Node next;
        public Node(){};
        public T getL(){
            return l;
        }
    }
    public GenericSinglyLinkedList(){
        header = new Node();
        header.l = null;
        header.next = null;
    }
    public boolean insert(T newObject){
        Node n = new Node();
        if(n == null){
            return false;
        } else{
            n.next = header.next;
            header.next = n;
            n.l = newObject;
            return true;
        }
    }
    public T fetch(T targetObject){
        Node p = header.next;
        while(p != null && !(p.l == targetObject)){
            p = p.next;
        }
        if(p != null){
            return p.getL();
        } else{
            return null;
        }
    }
    public boolean delete(T targetObject){
        Node q = header;
        Node p = header.next;
        while(p != null && !(p.l == targetObject)){
            q = p;
            p = p.next;
        }
        if(p != null){
            q.next = p.next;
            return true;
        } else{
            return false;
        }
    }
    public boolean update(T targetObject, T newObject){
        if(delete(targetObject) == false){
            return false;
        } else if(insert(newObject) == false){
            return false;
        } return true;
    }
    public void showAll(){
        Node p = header.next;
        while(p != null){
            System.out.println(p.l.toString());
            p = p.next;
        }
    }
}

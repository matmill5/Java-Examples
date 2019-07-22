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
public class SinglyLinkedList {
    private Node header;
    
    public class Node{
        private Listing l;
        private Node next;
        public Node(){};
    }
    public SinglyLinkedList(){
        header = new Node();
        header.l = null;
        header.next = null;
    }
    public boolean insert(Listing newListing){
        Node n = new Node();
        if(n == null){
            return false;
        } else{
            n.next = header.next;
            header.next = n;
            n.l = newListing.deepCopy();
            return true;
        }
    }
    public Listing fetch(String targetKey){
        Node p = header.next;
        while(p != null && !(p.l.compareToString(targetKey) == 0)){
            p = p.next;
        }
        if(p != null){
            return p.l.deepCopy();
        } else{
            return null;
        }
    }
    public boolean delete(String targetKey){
        Node q = header;
        Node p = header.next;
        while(p != null && !(p.l.compareToString(targetKey) ==  0)){
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
    public boolean update(String targetKey, Listing newListing){
        if(delete(targetKey) == false){
            return false;
        } else if(insert(newListing) == false){
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

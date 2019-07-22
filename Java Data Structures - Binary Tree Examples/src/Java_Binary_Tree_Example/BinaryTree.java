/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Binary_Tree_Example;

/**
 *
 * @author Matthew
 */
public class BinaryTree {
    TreeNode root;
    public class TreeNode{
        private Listing node;
        private TreeNode lc;
        private TreeNode rc;
        public TreeNode(){};
    }
    public BinaryTree(){
        root = null;
    }
    public class TreeNodeWrapper{
        TreeNode treeRef = null;
        public TreeNodeWrapper(){};
        public TreeNode get(){
            return treeRef;
        }
        public void set(TreeNode t){
            treeRef = t;
        }
    }
    public boolean insert(Listing newListing){
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode n = new TreeNode();
        if(n == null){
            return false; //out of memory.
        }else{
            n.node = newListing.deepCopy();
            n.lc = null;
            n.rc = null;
            if(root == null ){ root = n; }//Tree is empty
            else{
                   findNode(newListing.getName(), p, c); //Find the node's parent
                   if(newListing.getName().compareTo(p.get().node.getName()) < 0){
                       p.get().lc = n;
                   }else{
                       p.get().rc = n; //Insert new node as right child.
                   }
            }
            return true;
        }
    }
    public Listing fetch(String targetKey){
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        found = findNode(targetKey, p, c); //Locate the node
        if(found == true){
            return c.get().node.deepCopy();
        } else{
            return null;
        }
    }
    public boolean delete(String targetKey){
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode largest;
        TreeNode nextLargest;
        found = findNode(targetKey, p, c);
        if(found == false){
            return false; //Node not found
        } else{ //If not found, identify the case number
           if(c.get().lc == null && c.get().rc == null){ //Case 1. deleted node has no children
               if(p.get().lc == c.get()) //Deleted node is a left child
                   p.get().lc = null;
               else //Deleted node is a right child
                   p.get().rc = null;
           }
           else if(c.get().lc == null || c.get().rc == null){ //case 2: 1 child 
               if(p.get().lc == c.get()){ //Deleted  nose is a left child
                   if(c.get().lc != null) //Deleted node has a left child
                       p.get().lc = c.get().lc;
                   else
                       p.get().lc = c.get().rc;
               } else{ //Deleted node has a right child
                   if(c.get().lc != null) //Deleted node has a left child
                       p.get().rc = c.get().lc;
                   else
                       p.get().rc = c.get().rc;
               }
           } else{ //Case 3: deleted node has two children
               nextLargest = c.get().lc;
               largest = nextLargest.rc;
               if(largest != null){ //left child has right subtree
                   while(largest.rc != null){ //mode down right subtree
                       nextLargest = largest;
                       largest = largest.rc;
                   }
                   c.get().node = largest.node; //overwrite the deleted node
                   nextLargest.rc = largest.lc; //svae the left subtree
               } else{ //Left child does not have a right subtree
                   nextLargest.rc = c.get().rc; // save the right subtree
                   if(p.get().lc == c.get()) // deleted node is a left child
                       p.get().lc = nextLargest; //jump around deleted node
                   else // deleted node is right child
                       p.get().rc = nextLargest; //Jump around deleted node
               }
             }
           return true;
           }
        }
        public boolean update(String targetKey, Listing newListing){
            if(delete(targetKey) == false)
                return false;
            else if(insert(newListing) == false)
                return false;
            return true;
        }
        private boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child){
            parent.set(root);
            child.set(root);
            if(root == null){
                return true;
            }
            while(child.get() != null){
                if(child.get().node.compareToString(targetKey) == 0) //Node found
                    return true;
                else{
                    parent.set(child.get());
                    if(targetKey.compareTo(child.get().node.getName()) < 0){
                        child.set(child.get().lc);
                    } else{
                        child.set(child.get().rc);
                    }
                }
            }
            return false;
        }
        public TreeNode getRoot(){
            return root;
        }
        public void printTree(TreeNode root){
            // Base case  
            if (root == null){
               System.out.println("Tree is empty");
               return;
            }
            printTree(root.lc);
            System.out.println(root.node.toString());
            printTree(root.rc);
        }
}

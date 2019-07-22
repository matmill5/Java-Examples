/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Merge_Sort_Example;

import java.util.Random;

/**
 *
 * @author Matthew
 */
public class Java_Merge_Sort_Example_Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create instance of Random class 
        Random rand = new Random(); 
        int[] intArray = new int[100];
        for(int i = 0; i < intArray.length; i++){
            // Generate random integers in range 0 to 999 
            intArray[i] = rand.nextInt(1000); 
        }
        // Print random integers 
        System.out.println("==============unSorted Array===============");
        for(int i = 0; i < intArray.length; i++){
            System.out.println(i + ", " + intArray[i]);
        }
        
        MergeSort aMergesort = new MergeSort();
        aMergesort.sort(intArray, 0, intArray.length - 1);
        System.out.println("==============Sorted Array===============");
        for(int i = 0; i < intArray.length; i++){
            System.out.println(i + ", " + intArray[i]);
        }
    }
}

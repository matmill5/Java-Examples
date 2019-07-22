/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elactics_Interview_Question;

import java.util.Comparator;

/**
 *
 * @author Matthew
 */
public class SortBySuit implements Comparator<Card>{
        // Used for sorting in ascending order of cards by suit 
        @Override
        public int compare(Card a, Card b) { 
            return a.getSuit() - b.getSuit(); 
        }
}

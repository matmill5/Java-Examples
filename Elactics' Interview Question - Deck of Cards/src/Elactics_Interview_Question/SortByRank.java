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
class SortByRank implements Comparator<Card> { 
        // Used for sorting in ascending order of cards by rank
        @Override
        public int compare(Card a, Card b) { 
            return a.getRank() - b.getRank();
        } 
}

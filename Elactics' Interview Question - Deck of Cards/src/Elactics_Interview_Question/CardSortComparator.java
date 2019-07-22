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
public class CardSortComparator implements Comparator<Card> { 

    @Override
    public int compare(Card a, Card b) { 

        //Values to be compared 
        int SuitCompare = a.getSuit() - b.getSuit();
        int RankCompare = a.getRank() - b.getRank();

        //2-level comparison using if-else block 
        if (SuitCompare == 0) { 
            return ((RankCompare == 0) ? SuitCompare : RankCompare); 
        } else { 
            return SuitCompare; 
        }
    } 
}

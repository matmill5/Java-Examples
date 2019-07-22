/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elactics_Interview_Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Matthew
 */
public class Deck {
    private List<Card> aDeck; //List to hold the deck of cards
    
    Deck(){
        //Create new space for a deck of 52 cards
        aDeck = new ArrayList<>(52);
        
        //Loop through the suits 0-3(DIAMONDS , HEARTS, CLUBS, SPADES)
        for(int suit = 0; suit < 4; suit++){
            //Loop through ranks 2(TWO)-14(ACE)
            for(int rank = 2; rank < 15; rank++){
                aDeck.add(new Card(rank, suit)); //Insert a newly initialized card into the deck
            }
        }
    }
    //Prints the size of the List<Card> aka 'Deck' to the console
    public void printDeckSize(){
        System.out.println(aDeck.size() + " cards in the deck." + "\n");
    }
    //Prints the total contents of the deck
    public void printDeck(){
        for(int index = 0; index < aDeck.size(); index++){
            System.out.println(aDeck.get(index).rankToString() + " of " + aDeck.get(index).suitToString());
        }
        System.out.println();
    }
    //Sorts the deck into a random order, like shuffling a deck of cards
    public void shuffleDeck(){
        Collections.shuffle(aDeck, new Random());
    }
    //Sorts the deck by rank. Uses Collections and Comparator
    public void rankSortDeck(){
        Collections.sort(aDeck, new SortByRank());
    }
    //Sorts the deck by suit. Uses Collections and Comparator
    public void suitSortDeck(){
        Collections.sort(aDeck, new SortBySuit());
    }
    //Sorts the deck by suit and then rank, like a fresh pack of cards. Uses Collections and Comparator
    public void freshPackSortDeck(){
        Collections.sort(aDeck, new CardSortComparator());
    }
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elactics_Interview_Question;

/**
 *
 * @author Matthew E. Miller
 */
public class Elactics_Interview_Question_Deck_of_Cards_Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
          This program is for an interview coding test at Etactics in Stow, OH.
          The program creates 52 card objects, each with a suit and rank.
          Then it creates a deck object which is populated with the 52 cards.
          Finally, it does operations on the deck.
          These ops are in the following order:
            -> Print deck size, shuffle deck & print, 
            -> rank-sort deck & print, suit-rank-sort deck & print
        */
        
        Deck newDeck = new Deck();
        newDeck.printDeckSize();
        
        System.out.println("Shuffled Deck:");
        newDeck.shuffleDeck();
        newDeck.printDeck();
        
        System.out.println("Sorted by Rank:");
        newDeck.rankSortDeck();
        newDeck.printDeck();
        
        System.out.println("Sorted by Suit and Rank:");
        newDeck.freshPackSortDeck();
        newDeck.printDeck();
    }
}

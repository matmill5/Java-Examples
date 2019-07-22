/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elactics_Interview_Question;

/**
 *
 * @author Matthew
 */
public class Card {
    private int rank;
    private int suit;
    
    //Default constructor, card has no-rank and no-suit
    Card(){
        rank = -1;
        suit = -1;
    }
    //Rank and Suit constructor, card has a valid rank and valid suit
    Card(int aRank, int aSuit){
        rank = aRank;
        suit = aSuit;
    }
    //Returns the card's rank
    int getRank(){
        return rank;
    }
    //Returns the card's suit
    int getSuit(){
        return suit;
    }
    //Sets the card's rank
    void setRank(int aRank){
        rank = aRank;
    }
    //Sets the card's suit
    void setSuit(int aSuit){
        suit = aSuit;
    }
    //Used to convert integer representation of rank to a string rep
    String rankToString(){
        String strResult = "NO RANK";
        switch (rank) { 
            case -1:
                strResult = "-1 RANK";
                return  strResult;
            case 0:
                strResult = "0 RANK";
                return  strResult;
            case 1:
                strResult = "1 RANK";
                return  strResult;
            case 2:
                strResult = "TWO";
                return  strResult;
            case 3:
                strResult = "THREE";
                return  strResult;
            case 4:
                strResult = "FOUR";
                return  strResult;
            case 5:
                strResult = "FIVE";
                return  strResult;
            case 6:
                strResult = "SIX";
                return  strResult;
            case 7:
                strResult = "SEVEN";
                return  strResult;
            case 8:
                strResult = "EIGHT";
                return  strResult;
            case 9:
                strResult = "NINE";
                return  strResult;
            case 10:
                strResult = "TEN";
                return  strResult;
            case 11:
                strResult = "JACK";
                return  strResult;
            case 12:
                strResult = "QUEEN";
                return  strResult;
            case 13:
                strResult = "KING";
                return  strResult;
            case 14:
                strResult = "ACE";
                return  strResult;
            default: 
                return strResult;
        }
    }
    //Used to convert integer representation of suit to a string rep
    String suitToString(){
        String strResult = "NO SUIT";
        switch(suit){
            case 0:
                strResult = "DIAMONDS";
                return strResult;
            case 1:
                strResult = "HEARTS";
                return strResult;
            case 2:
                strResult = "CLUBS";
                return strResult;
            case 3:
                strResult = "SPADES";
                return strResult;
            default:
                return strResult;
        }
    }
}

package cggmain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

/**
 * main handler class for the Hands objects
 * 
 * @author chris
 */
public class Hands {
    
   private Vector<Integer> hand= new Vector<Integer>(); //one players hand
   
   Hands(){
       hand.setSize(0);
   }
    
   /**
     * Returns the vector containing all cards (if any) in a hand object
     * 
     * @return
     */
    Vector<Integer> getHand(){
        return hand;
    }
    
    /**
     * Sets a preexisting hand(vector) to a hand for use(vector)
     * 
     * @param newHand Vector<Int> that will be assigned as the new hand
     */
    void setHand(Vector<Integer> newHand){ 
        hand=newHand;
    }
    
    /**
     * sort the players hand for them
     * 
     * @param oldHand the hand object that will be sorted
     * @return 
     */
    void SortHand(){
        Vector<Integer> sortedHand= new Vector<Integer>(); //A new vector used to sort the original hand
        int small=55; //integer used to keep track of smallest value in hand
        while (!hand.isEmpty()){ //stops when then hand is empty
            for (int x=0; x<hand.size(); x++){ //runs through whole hand
                if (small>hand.elementAt(x)) small=hand.elementAt(x); 
            }
            sortedHand.add(small); //adds smallest to the next index
            hand.removeElement(small); 
            small=55;
        }
        hand=sortedHand;
    }
    
    /**
     * Returns the value of the first card in a hand
     * 
     * @return 
     */
    int NumDefault(){
        int num=getHand().firstElement();
        while (num>=15) num-=13;
        return num;
    }
    
    /**
     * Adds a card to end of the deck
     * 
     * @param card the value of the card to be added
     */
    void AddCard(int card){ 
        hand.add(card);
    }
    
    /**
     * Will remove a card from deck
     * 
     * @param card the value of the card to be removed
     */
    void RemoveCard(int card){ 
        hand.removeElement(card); //This removes the first occurent of card since no cards duplicate that is ok.
    }
    
    /**
     * return the size of the hand
     * 
     * @return 
     */
    int getSize(){ 
        return hand.size();
    }
}

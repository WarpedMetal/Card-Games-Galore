package cggmain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

/**
 *
 * @author chris
 */
public class Hands {
    
   private Vector<Integer> hand= new Vector<Integer>(); //one players hand
   
   Hands(){
       hand.setSize(0);
   }
    
    Vector<Integer> getHand(){
        /**
         * Returns the vector containing all cards (if any) in a hand object
         */
        return hand;
    }
    
    void setHand(Vector<Integer> newHand){ 
        /**
         * Sets a preexisting hand(vector) to a hand for use(vector)
         */
        hand=newHand;
    }
    
    Vector<Integer> SortHand(Vector<Integer> oldHand){
        /**
         * sort the players hand for them
         */
        Vector<Integer> sortedHand= new Vector<Integer>(); //A new vector used to sort the original hand
        int small=55; //integer used to keep track of smallest value in hand
        while (!oldHand.isEmpty()){ //stops when then hand is empty
            for (int x=0; x<oldHand.size(); x++){ //runs through whole hand
                if (small>oldHand.elementAt(x)) small=oldHand.elementAt(x); 
            }
            sortedHand.add(small); //adds smallest to the next index
            oldHand.removeElement(small); 
            small=55;
        }
        return sortedHand;
    }
    
    int NumDefault(){
        /**
         * Returns the value of the first card in a hand
         */
        int num=getHand().firstElement();
        while (num>=15) num-=13;
        return num;
    }
    
    void AddCard(int card){ 
        /**
         * Adds a card to end of the deck
         */
        hand.add(card);
    }
    
    void RemoveCard(int card){ 
        /**
         * Will remove a card from deck
         */
        hand.removeElement(card); //This removes the first occurent of card since no cards duplicate that is ok.
    }
    
    int getSize(){ 
        /**
         * return the size of the hand
         */
        return hand.size();
    }
}

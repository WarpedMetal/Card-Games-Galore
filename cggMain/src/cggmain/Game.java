package cggmain;

import java.util.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris/bryce
 */
public class Game{
    
    private Vector<Integer> deck=new Vector<Integer>();   //deck of 52 cards (vector for easy removal of cards from deck)
    
    void Game(){ 
        for (int x=2; x<54;x++){    //these cards are labeled from 2-54 Where Jack = 11, Queen = 12, King = 13, Ace= 14. You can subtract 13 to get other card in other suit
            deck.add(x);                //suits will go clubs,spades,diamonds,hearts
        }
    }
    
    /**
     * Returns the deck object
     * 
     * @return 
     */
    Vector<Integer> getDeck(){
        return deck;
    }
    
    /**
     * Checks if the deck itself is out of cards
     * 
     * @return 
     */
    boolean isDeckEmpty(){
        return deck.isEmpty();
    }
    
    /**
     * Returns the value of the topmost card of the deck (pull from the top)
     * 
     * @return 
     */
    int takeTopCard(){
       int val = deck.firstElement();
       deck.removeElement(deck.firstElement());
       return val; 
    }
        
    /**
     * this will shuffle the deck at any deck size
     */
    void Shuffle(){
        Vector<Integer> shuffledDeck=new Vector<Integer>(0); //new vector for the shuffled deck
        int randomNum=0; //integer to obtain a random number
        int tempsize=deck.size();
        for (int x=0; x<tempsize; x++){
            randomNum=(int)(Math.random()*(52-x)); //random number between 0 and 51-x
            shuffledDeck.add(deck.elementAt(randomNum));
            deck.remove(randomNum);
        }
        deck=shuffledDeck;
    }
    
    /**
     * this will deal the deck to one player for any hand size
     * 
     * @param handSize
     * @return 
     */
    Vector<Integer> Deal(int handSize){
        Vector<Integer> allHands=new Vector<Integer>();
        for (int x=0; x<handSize; x++){
            allHands.add(deck.elementAt(0)); 
            deck.remove(0); //remove card from deck after it's dealt
        }
        return allHands;
    }
    
}
import java.util.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris
 */
public class Game{
    
    private Vector<Integer> deck=new Vector<Integer>();   //deck of 52 cards (vector for easy removal of cards from deck)
    
    void Game(){ 
        for (int x=2; x<54;x++){    //these cards are labeled from 2-54 Where Jack = 11, Queen = 12, King = 13, Ace= 14. You can subtract 13 to get other card in other suit
            deck.add(x);                //suits will go clubs,spades,diamonds,hearts
        }
    }
    
    Vector<Integer> getDeck(){
        return deck;
    }
        
    void Shuffle(){  //this will shuffle the deck at any deck size
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
    
    Vector<Integer> Deal(int handSize){ //this will deal the deck to one player for any hand size
        Vector<Integer> allHands=new Vector<Integer>();
        for (int x=0; x<handSize; x++){
            allHands.add(deck.elementAt(0)); 
            deck.remove(0); //remove card from deck after it's dealt
        }
        return allHands;
    }
    
}
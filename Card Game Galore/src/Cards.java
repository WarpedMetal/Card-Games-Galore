import java.util.*;
import java.lang.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris
 */
public class Cards {
    
    private Vector<Integer> deck=new Vector<Integer>(52);   //deck of 52 cards (vector for easy removal of cards from deck)
    
    void Cards(){ 
        for (int x=2; x<=54;x++){    //these cards are labeled from 2-54 Where Jack = 11, Queen = 12, King = 13, Ace= 14. You can subtract 13 to get other card in other suit
            deck.add(x-2,x);                //suits will go clubs,spades,diamonds,hearts
        }
    }
        
    void Shuffle(){  //this will shuffle the deck at any deck size
        
    }
    
    int[] Deal(int handSize){ //this will deal the deck to one player for any hand size
        int[] allHands=new int[handSize];
        for (int x=0; x<handSize; x++){
            allHands[x]=deck.elementAt(x); 
            deck.remove(x); //remove card from deck after it's dealt
        }
        return allHands;
    }
    
    public Vector<Integer> Sort(Vector<Integer> sortCards){ // can sort any players hand or the whole deck if needed
        
        return sortCards;
    }
}

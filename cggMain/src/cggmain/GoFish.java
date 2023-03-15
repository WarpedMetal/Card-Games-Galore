package cggmain;

import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris
 */
public class GoFish extends Game {
    
    private int handSize;
    private int playerCount;
    
    GoFish(){
        handSize=7;
        playerCount=2;
    }    
    
    int getHandSize(){
        /**
         * Returns the value of 7 (the default hand size of Go Fish)
         */
        return handSize;
    }
    
    int getPlayerCount(){
        return playerCount;
    }
    
    void Gameplay() {
        /**
         * Runs the main loop of Go Fish
         */
        // create player and AI hands
        Hands player=new Hands();
        Hands AI=new Hands();
        // create war card deck
        Game gfDeck=new Game();
        gfDeck.Shuffle();
        // deal deck to player and AI accordingly based on initial hand size
        player.setHand(gfDeck.Deal(getHandSize()));
        AI.setHand(gfDeck.Deal(getHandSize()));
        // initialization values
        Scanner scan = new Scanner(System.in);
        int valAsked = 55;
        int cardCount = 0;
        while (!gfDeck.isDeckEmpty()){
            System.out.println("Your hand is: " + player.getHand());
            System.out.println("What card will you ask for? (11 = jack, 12 = queen, 13 = king, 14 = ace)");
            valAsked = scan.nextInt();
            Vector<Integer> temp = new Vector<>();
            if(AI.getHand().contains(valAsked)){
                for(int x = 0; x < AI.getHand().size(); x++){
                    // check how many of that card they have
                    if(AI.getHand().elementAt(x) == valAsked){
                        cardCount++;
                    }
                }
                for(int i = 0; i < cardCount; i++){
                    player.AddCard(i);
                }
            }
        }
    }
    
}

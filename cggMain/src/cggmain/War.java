package cggmain;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * main class handler for War objects
 * 
 * @author chris/bryce/jordan
 */
public class War extends Game{
    
    private int handSize;
    private int playerCount;
    private Hands person;
    private Hands AI;
    private Game war;
    private boolean gamePlaying;
    private Vector<Integer> ties;
    
    War(){
        handSize=26;
        playerCount=2;
        person=new Hands();
        AI=new Hands();
        war=new Game();
        war.Game();
        war.Shuffle();
        person.setHand(war.Deal(getHandSize()));
        AI.setHand(war.Deal(getHandSize()));
        gamePlaying=true;
        ties=new Vector<Integer>();
    }
    
    /**
     * returns the first card value in the player's deck
     * 
     * @return 
     */
    int getPlayerCard(){
        return person.getHand().elementAt(0);
    }
    
    /**
     * returns the first card value in the AI's deck
     * 
     * @return 
     */
    int getAICard(){
        return AI.getHand().elementAt(0);
    }
    
    /**
     * returns the handSize variable
     * 
     * @return 
     */
    int getHandSize(){
        return handSize;
    }
    
    /**
     * returns the amount of players (war can only have 2, so this is deprecated)
     * 
     * @return 
     */
    int getPlayerCount(){
        return playerCount;
    }
    
    /**
     * returns the true/false status of if a game is currently active
     * 
     * @return 
     */
    boolean getGamePlaying(){
        return gamePlaying;
    }
    
    /**
     * runs the main loop and guts of a War game round
     */
    void Gameplay(){
        //These values are used to pull NumDefault for players hands to make it make more sense for me
        int personNum=0;
        int AINum=0;
            // grab the player and AI's firstmost card value
            personNum=person.NumDefault();
            AINum=AI.NumDefault();
            //Tell the player what cards were played
           // System.out.print("You played: ");
           // System.out.println(person.getHand().firstElement()+", "+personNum);
           // System.out.print("The AI played: ");
           // System.out.println(AI.getHand().firstElement()+", "+AINum);
                if(personNum>AINum){
                    for (int x=0; x<ties.size();x++){
                        person.AddCard(ties.elementAt(x));
                        if (x+1==ties.size()) ties.clear();
                    }
                    //Add the first card from both players hands then remove them from the front of their hands
                    person.AddCard(AI.getHand().firstElement());
                    person.AddCard(person.getHand().firstElement());
                    person.RemoveCard(person.getHand().firstElement());
                    AI.RemoveCard(AI.getHand().firstElement());
                   // System.out.println("You won that round!");
                }
                else if (personNum<AINum){
                    for (int x=0; x<ties.size();x++){
                        AI.AddCard(ties.elementAt(x));
                        if (x+1==ties.size()) ties.clear();
                    }
                    //Add the first card from both players hands then remove them from the front of their hands
                    AI.AddCard(person.getHand().firstElement());
                    AI.AddCard(AI.getHand().firstElement());
                    person.RemoveCard(person.getHand().firstElement());
                    AI.RemoveCard(AI.getHand().firstElement());
                   // System.out.println("The AI won that round.");
                }
                else{
                    while (personNum == AINum){
                       // System.out.println("Y'all tied this round!\nThis means WAR!");
                        //This loop adds all cards in a war into a vector for later use.
                        for (int x=0; x<4; x++){
                            if(person.getHand().isEmpty()) break;
                            if(AI.getHand().isEmpty()) break;
                            ties.add(person.getHand().firstElement());
                            ties.add(AI.getHand().firstElement());
                           // System.out.println(person.getHand().firstElement() + ", " + AI.getHand().firstElement());
                            //This removes the cards used in a war from their hand
                            person.RemoveCard(person.getHand().firstElement());
                            AI.RemoveCard(AI.getHand().firstElement());
                            personNum=person.NumDefault();
                            AINum=AI.NumDefault();
                        }
                    } 
                }
            //System.out.println(person.getHand()+"\n"+AI.getHand());
        
        int wol=0; //value for win or lost
        if (AI.getHand().isEmpty()){
           // System.out.println("Congratulations, You WON!");
            wol=1;
            saveStats("WarStats",wol); //Saving their stats
            gamePlaying=false;
        }
        else if (person.getHand().isEmpty()){
           // System.out.println("Better Luck Next Time, The AI Beat You.");
            saveStats("WarStats",wol); //Saving their stats
            gamePlaying=false;
        }
    }
}

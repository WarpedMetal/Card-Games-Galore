package cggmain;

import java.util.*;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bryce
 */
public class GoFish extends Game {
    
    private final int handSize;
    private final int playerCount;
    private Hands person;
    private Hands AI;
    private Game goFish = new Game();
    private boolean gamePlaying;
    public int playerBooks;
    public int AIBooks;
    public int winner;
    
    GoFish(){
        handSize=7;
        playerCount=2;
        playerBooks=0;
        AIBooks=0;
        person=new Hands();
        AI=new Hands();
        goFish.Game();
        goFish.Shuffle();
        person.setHand(goFish.Deal(7));
        AI.setHand(goFish.Deal(7));
        gamePlaying=true;
    }    
    
    /**
     * Returns the value of 7 (the default hand size of Go Fish)
     * 
     * @return 
     */
    int getHandSize(){
        return handSize;
    }
    
    int getPlayerCount(){
        return playerCount;
    }
    
    int getPlayerBooks(){
        return playerBooks;
    }
    
    int getAIBooks(){
        return AIBooks;
    }
    
    boolean isGame(){
        return gamePlaying;
    }
    
    int getAISize(){
        return AI.getSize();
    }
    
    /**
     * This function is called on game start and sets up ai and player hands
     */
    Hands startMatch(){
        return person;
    }
    
    /**
     * This function checks for 4 of a kinds in a hand
     * and gives the point to whoever is passed in to PC
     * 
     * @param   hand    the Hands object that will be analyzed
     * @param   PC      the integer variable telling 1 for player, else for the AI
     * @return          the Hands object back, possibly modified if there were books
     */
    Hands checkForBook(Hands hand, int PC){
        Vector<Integer> indexC = new Vector<>();
        int tempVal;
        int checkVal;
        // nested loop to sort through every card in the hand
        for(int i = 0; i < hand.getSize(); i++){
            // get the 'i'th card in the hand as the base card
            checkVal = hand.getHand().elementAt(i);
            // clean it up so that duplicates can actually exist
            while(checkVal > 14) {checkVal -= 13;}
            // temporarily store the index of this card in the temp vector
            indexC.add(hand.getHand().elementAt(i));
            // now check the rest of the deck for same cards
            for(int j = i+1; j < hand.getSize(); j++){
                tempVal = hand.getHand().elementAt(j);
                while(tempVal > 14) {tempVal -= 13;}
                if(checkVal == tempVal){
                    // when one is found, store the index of it
                    indexC.add(hand.getHand().elementAt(j));
                }
            }
            // if there is a book, increment counter and remove the cards from the hand
            if(indexC.size() == 4){
                if(PC == 1) {
                    playerBooks++;
                    tempVal = indexC.firstElement();
                    while(tempVal > 14) {tempVal-=13;}
                    System.out.println("\nYou earned a book! you found 4 " + tempVal + "'s.\n");
                    for(int x = 3; x >= 0; x--){
                        hand.RemoveCard(indexC.elementAt(x));
                    }
                }
                else {
                    AIBooks++;
                    tempVal = indexC.firstElement();
                    while(tempVal > 14) {tempVal-=13;}
                    System.out.println("\nThe CPU earned a book. It found 4 " + tempVal + "'s.\n");
                    for(int x = 3; x >= 0; x--){
                        hand.RemoveCard(indexC.elementAt(x));
                    }
                }
            }
            // clear the temp vector for the next set of card searching
            indexC.clear();
        }
        return hand;
    }
    
    /**
     * Runs the main loop of Go Fish
     * 
     * @param choice    the choice value of the player from their hand
     * @param turn      the variable showing who's turn it is (1 for player, else for AI)
     * @return          returns the player's hand after the turn
     */
    Hands Gameplay(int choice, int turn) {
        Vector<Integer> cardIndices = new Vector<>();
        boolean playerT;
        playerT = (turn == 1);
        // there can only ever be 13 books in a game of Go Fish
        if (gamePlaying){
            // player's turn
            cardIndices.clear();
            if(playerT == true){
                if (person.getHand().isEmpty()){
                    person.AddCard(goFish.takeTopCard());
                }
                Vector<Integer> cleanHand = new Vector<>();
                cleanHand.addAll(person.getHand());
                System.out.print("\n\nYour hand is: ");
                for(int i = 0; i < person.getSize()-1; i++){
                    int val = cleanHand.get(i);
                    while(val > 14) {val -= 13;}
                    System.out.print("(" + val + ") " + person.getHand().get(i) + ", ");
                }
                int valL = cleanHand.lastElement();
                while(valL > 14) {valL -= 13;}
                System.out.println("(" + valL + ") " + person.getHand().lastElement());
                cleanHand.clear();
                cleanHand.addAll(AI.getHand());
                System.out.print("The AI's hand is: ");
                for(int i = 0; i < AI.getSize()-1; i++){
                    int val = cleanHand.get(i);
                    while(val > 14) {val -= 13;}
                    System.out.print("(" + val + ") " + AI.getHand().get(i) + ", ");
                }
                valL = cleanHand.lastElement();
                while(valL > 14) {valL -= 13;}
                System.out.println("(" + valL + ") " + AI.getHand().lastElement() + "\n\n");
                // make a duplicate vector to attain index values
                Vector<Integer> temp = new Vector<>();
                temp.addAll(AI.getHand());
                // start by making all values in the temp vector in range of 2-14
                for(int i = 0; i < temp.size(); i++){
                    while(temp.get(i) > 14){
                        temp.set(i, temp.get(i)-13);
                    }
                }
                // now check if the AI has the card asked for
                int chosen = person.getHand().elementAt(choice);
                while (chosen > 14) {chosen -= 13;}
                System.out.println("you chose card value: " + String.valueOf(chosen));
                if(temp.contains(chosen)){
                    System.out.println("Works");
                    // if so, see how many instances exist and get their index values
                    for(int x = 0; x < temp.size(); x++){
                        if(Objects.equals(temp.elementAt(x), chosen)){
                            cardIndices.add(x);
                        }
                    }
                    // add the card to the player's hand and remove it from the AI's hand
                    // this is done in reverse order so we don't have to worry about index handling
                    for(int i = cardIndices.size()-1; i >= 0; i--){
                        person.AddCard(AI.getHand().elementAt(cardIndices.get(i)));
                        AI.RemoveCard(person.getHand().lastElement());
                    }
                    System.out.println("You got " + cardIndices.size() + " card(s) from the CPU and you get to go again.\n");
                }
                else{
                    if(goFish.isDeckEmpty()){
                        System.out.println("I would say Go Fish, but there's no more cards in the deck");
                        System.out.println("Just pick a different card next time");
                    }
                    else {
                        System.out.println("Go Fish");
                        person.AddCard(goFish.takeTopCard());
                    }
                }
                person = checkForBook(person, 1);
            }
            // CPU's turn
            else{
                if (AI.getHand().isEmpty()){
                    AI.AddCard(goFish.takeTopCard());
                }
                Random randGen = new Random();
                // choose a card from the CPU's hand
                int randNum = randGen.nextInt(AI.getSize());
                int valAsked = AI.getHand().elementAt(randNum);
                while(valAsked > 14) {valAsked-=13;}
                System.out.println("The CPU is fishing for any " + valAsked + " card(s) you have");
                // make a duplicate vector to attain index values
                Vector<Integer> temp = new Vector<>();
                temp.addAll(person.getHand());
                // start by making all values in the temp vector in range of 2-14
                for(int i = 0; i < temp.size(); i++){
                    while(temp.get(i) > 14){
                        temp.set(i, temp.get(i)-13);
                    }
                }
                // now check if the player has the card asked for
                if(temp.contains(valAsked)){
                    // if so, see how many instances exist and get their index values
                    for(int x = 0; x < temp.size(); x++){
                        if(temp.elementAt(x) == valAsked){
                            cardIndices.add(x);
                        }
                    }
                    // add the card to the AI's hand and remove it from the player's hand
                    // this is done in reverse order so we don't have to worry about index handling
                    for(int i = cardIndices.size()-1; i >= 0; i--){
                        AI.AddCard(person.getHand().elementAt(cardIndices.get(i)));
                        person.RemoveCard(AI.getHand().lastElement());
                    }
                    System.out.println("The CPU got " + cardIndices.size() + " card(s) from you and will now go again\n");
                }
                else{
                    if(goFish.isDeckEmpty()){
                        System.out.println("The CPU would Go Fish, but there's no more cards in the deck");
                    }
                    else {
                        System.out.println("The CPU will Go Fish");
                        AI.AddCard(goFish.takeTopCard());
                    }
                }
                AI = checkForBook(AI, 2);
            }
        }
        else
        {
            return person;
        }
        if((playerBooks + AIBooks) == 13){
            gamePlaying = false;
            if(playerBooks > AIBooks){
                System.out.println("You won!");
                System.out.println("You had " + playerBooks + " books whereas the CPU had " + AIBooks + " Books.");
                winner = 1;
                saveStats("GoFishStats",1);  //save their stats 1 for win
            }
            else {
                System.out.println("The CPU has beat you.");
                System.out.println("You had " + playerBooks + " books whereas the CPU had " + AIBooks + " Books.");
                winner = 0;
                saveStats("GoFishStats",0);   //save their stats 0 for loss
            }
        }
        if (!goFish.isDeckEmpty()){
            if (person.getHand().isEmpty()){
                person.AddCard(goFish.takeTopCard());
            }
            if (AI.getHand().isEmpty()){
                AI.AddCard(goFish.takeTopCard());
            }
        }
        return person;
    }
}

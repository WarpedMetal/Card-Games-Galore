package cggmain;

import java.util.*;

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
    public int playerBooks;
    public int AIBooks;
    
    GoFish(){
        handSize=7;
        playerCount=2;
        playerBooks=0;
        AIBooks=0;
        Game();
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
     */
    void Gameplay() {
        // create player and AI hands
        Hands player=new Hands();
        Hands AI=new Hands();
        // create war card deck
        Game gfDeck=new Game();
        gfDeck.Game();
        gfDeck.Shuffle();
        // deal deck to player and AI accordingly based on initial hand size
        player.setHand(gfDeck.Deal(7));
        AI.setHand(gfDeck.Deal(7));
        // initialization values
        Scanner scan = new Scanner(System.in);
        int valAsked = 55;
        Vector<Integer> cardIndices = new Vector<>();
        boolean playerT = true;
        // there can only ever be 13 books in a game of Go Fish
        while ((playerBooks + AIBooks) != 13){
            // player's turn
            cardIndices.clear();
            if(playerT == true){
                if (player.getHand().isEmpty()){
                    player.AddCard(gfDeck.takeTopCard());
                }
                Vector<Integer> cleanHand = new Vector<>();
                cleanHand.addAll(player.getHand());
                System.out.print("Your hand is: ");
                for(int i = 0; i < player.getSize()-1; i++){
                    int val = cleanHand.get(i);
                    while(val > 14) {val -= 13;}
                    System.out.print("(" + val + ") " + player.getHand().get(i) + ", ");
                }
                int val = cleanHand.lastElement();
                while(val > 14) {val -= 13;}
                System.out.println("(" + val + ") " + player.getHand().lastElement());
                System.out.println("What card will you ask for? (11 = jack, 12 = queen, 13 = king, 14 = ace)");
                valAsked = scan.nextInt();
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
                if(temp.contains(valAsked)){
                    // if so, see how many instances exist and get their index values
                    for(int x = 0; x < temp.size(); x++){
                        if(temp.elementAt(x) == valAsked){
                            cardIndices.add(x);
                        }
                    }
                    // add the card to the player's hand and remove it from the AI's hand
                    // this is done in reverse order so we don't have to worry about index handling
                    for(int i = cardIndices.size()-1; i >= 0; i--){
                        player.AddCard(AI.getHand().elementAt(cardIndices.get(i)));
                        AI.RemoveCard(player.getHand().lastElement());
                    }
                    System.out.println("You got " + cardIndices.size() + " card(s) from the CPU and you get to go again.\n");
                }
                else{
                    if(gfDeck.isDeckEmpty()){
                        System.out.println("I would say Go Fish, but there's no more cards in the deck");
                        System.out.println("Just pick a different card next time");
                    }
                    else {
                        System.out.println("Go Fish");
                        player.AddCard(gfDeck.takeTopCard());
                    }
                    playerT = false;
                }
                player = checkForBook(player, 1);
            }
            // CPU's turn
            else{
                if (AI.getHand().isEmpty()){
                    AI.AddCard(gfDeck.takeTopCard());
                }
                Random randGen = new Random();
                // choose a card from the CPU's hand
                int randNum = randGen.nextInt(AI.getSize());
                valAsked = AI.getHand().elementAt(randNum);
                while(valAsked > 14) {valAsked-=13;}
                System.out.println("The CPU is fishing for any " + valAsked + " card(s) you have");
                // make a duplicate vector to attain index values
                Vector<Integer> temp = new Vector<>();
                temp.addAll(player.getHand());
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
                        AI.AddCard(player.getHand().elementAt(cardIndices.get(i)));
                        player.RemoveCard(AI.getHand().lastElement());
                    }
                    System.out.println("The CPU got " + cardIndices.size() + " card(s) from you and will now go again\n");
                }
                else{
                    if(gfDeck.isDeckEmpty()){
                        System.out.println("The CPU would Go Fish, but there's no more cards in the deck");
                    }
                    else {
                        System.out.println("The CPU will Go Fish");
                        AI.AddCard(gfDeck.takeTopCard());
                    }
                    playerT = true;
                }
                AI = checkForBook(AI, 2);
            }
        }
        if(playerBooks > AIBooks){
            System.out.println("You won!");
            System.out.println("You had " + playerBooks + " books whereas the CPU had " + AIBooks + " Books.");
            saveStats("GoFishStats",1);  //save their stats 1 for win
        }
        else {
            System.out.println("The CPU has beat you.");
            System.out.println("You had " + playerBooks + " books whereas the CPU had " + AIBooks + " Books.");
            saveStats("GoFishStats",0);   //save their stats 0 for loss
        }
    }
}

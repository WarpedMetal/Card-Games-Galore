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
public class War extends Game {
    
    private int handSize;
    private int playerCount;
    
    War(){
        handSize=26;
        playerCount=2;
    }
    
    int getHandSize(){
        return handSize;
    }
    
    int getPlayerCount(){
        return playerCount;
    }
    
    void Gameplay(){
        /**
         * Runs the main loop of War
         */
        // create player and AI hands
        Hands person=new Hands();
        Hands AI=new Hands();
        // create war card deck
        Game war=new Game();
        war.Game();
        war.Shuffle();
        // deal deck to player and AI
        person.setHand(war.Deal(getHandSize()));
        AI.setHand(war.Deal(getHandSize()));
        // initialization values
        Scanner scan = new Scanner(System.in);
        int personNum=0;
        int AINum=0;
        // vector that will be used to store ties during the game
        Vector<Integer> ties=new Vector<Integer>();
        // "While the player and the AI have cards in their hand, can play"
        while (!person.getHand().isEmpty() && !AI.getHand().isEmpty()){
            // 2-line buffer for player to play their next card
            System.out.println("Enter p to play");
            char play=scan.next().charAt(0);
            // grab the player and AI's firstmost card value
            personNum=person.NumDefault();
            AINum=AI.NumDefault();
            System.out.print("You played: ");
            System.out.println(person.getHand().firstElement()+", "+personNum);
            System.out.print("The AI played: ");
            System.out.println(AI.getHand().firstElement()+", "+AINum);
            Vector<Integer> temp=new Vector<Integer>();
                if(personNum>AINum || (personNum == 2 && AINum == 14)){
                    temp=person.getHand();
                    for (int x=0; x<ties.size();x++){
                        temp.add(ties.elementAt(x));
                        if (ties.size()-1==x) person.setHand(temp);
                    }
                    ties.clear();
                    person.AddCard(AI.getHand().firstElement());
                    person.AddCard(person.getHand().firstElement());
                    person.RemoveCard(person.getHand().firstElement());
                    AI.RemoveCard(AI.getHand().firstElement());
                    System.out.println("You won that round!");
                }
                else if (personNum<AINum|| (personNum == 14 && AINum == 2)){
                    temp=AI.getHand();
                    for (int x=0; x<ties.size();x++){
                        temp.add(ties.elementAt(x));
                        if (ties.size()-1==x) AI.setHand(temp);
                    }
                    ties.clear();
                    AI.AddCard(person.getHand().firstElement());
                    AI.AddCard(AI.getHand().firstElement());
                    person.RemoveCard(person.getHand().firstElement());
                    AI.RemoveCard(AI.getHand().firstElement());
                    System.out.println("The AI won that round.");
                }
                else{
                    System.out.println("Y'all tied this round!");
                    ties.add(person.getHand().firstElement());
                    ties.add(AI.getHand().firstElement());
                    person.RemoveCard(person.getHand().firstElement());
                    AI.RemoveCard(AI.getHand().firstElement());
                }
        }
        if (AI.getHand().isEmpty()) System.out.println("Congratulations, You WON!");
        else System.out.println("Better Luck Next Time, The AI Beat You.");
    }
}

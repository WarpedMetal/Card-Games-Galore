package cggmain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.ImageIcon;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *  main handler class for everything related to a card deck used in a game
 * 
 * @author chris/bryce/jordan
 * hi everyone :D
 */
public class Game{
    
    private Vector<Integer> deck=new Vector<Integer>();   //deck of 52 cards (vector for easy removal of cards from deck)
    private String rules;   //A preditemined String that will show the player the rules;
    private String stats;   //A String that will save the stats of a Game and show them to the screen
    public static ImageIcon[] faceCardImage = new ImageIcon[54];
    
    void Game(){ 
        for (int x=2; x<54;x++){    //these cards are labeled from 2-54 Where Jack = 11, Queen = 12, King = 13, Ace= 14. You can subtract 13 to get other card in other suit
            deck.add(x);                //suits will go clubs,spades,diamonds,hearts
        }
        rules="";
        stats="";
        for (int i = 2; i < faceCardImage.length; i++){
            faceCardImage[i] = new ImageIcon((i+1)+".png");
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
     * this will deal the deck to one player for any specified hand size
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
    
    /**
     * used to set specific rules of a game should it need to be modified on the fly
     * 
     * @param specificRules 
     */
    void setRules(String specificRules){
        rules=specificRules;
    }
    
    /**
     * returns the rules of the game object
     * 
     * @return 
     */
    String getRules(){
        return rules;
    }
    
    /**
     * sets the stats of a specified game object
     * 
     * @param specificStats 
     */
    void setStats(String specificStats){
        stats=specificStats;
    }
    
    /**
     * returns the stats of a specified game object
     * 
     * @return 
     */
    String getStats(){
        return stats;
    }
    
    /*
    Games Won: 
    Games Lost: 
    Games Played: 
    Win Precentage: 
    */
    
    /**
     * the function used to save stats of a game's data to a persistent file
     * 
     * @param gamePath the filepath where the persistence file is located
     * @param wol the status of if the player won or lost the game
     */
    void saveStats(String gamePath, int wol){
        int won=0;
        int lost=0;  //some variables to help edit the stats
        int played=0;
        String homeDirectory = System.getProperty("user.home");  //setting homedirectory
        String fullDirSpec = homeDirectory + "\\CardGamesGalore\\"+gamePath+".txt";  //creating a file path in a string
        Path path = Paths.get(fullDirSpec); //setting the string to a path
        try {
            Files.createDirectories(path.getParent()); //creates any directories needed
            if (!Files.exists(path)) Files.createFile(path);  //creating the file itself
            readStats(gamePath); //This will set stats to whatever is in the file
            if (stats.equals("")){  //When empty set equal to this
                stats="Games Won: 0\n" +
                    "Games Lost: 0\n" +
                    "Games Played: 0\n" +
                    "Win Precentage: 0.0%";
            }
            String temp=stats.replaceAll("\\D+"," "); //Replacing everything that isn't an int with a space
            temp=temp.trim();  
            int index;
            index=temp.indexOf(" ");
            won=Integer.parseInt(temp.substring(0,index)); //Setting won to the value for games won
            int tempIndex=temp.indexOf(" ",index+1);
            lost=Integer.parseInt(temp.substring(index+1,tempIndex)); //Setting loss to the values for games lost
            played=won+lost;
            won+=wol; //Adding 1 to won if you won
            if (wol== 0)lost+=1; //Adding 1 to loss if you lost
            played=won+lost;
            float precentage=(float)won/played*100;  //calculating the win precentage
            stats="Games Won: "+won+"\n" +
                    "Games Lost: "+lost+"\n" +
                    "Games Played: "+played+"\n" +
                    "Win Precentage: "+precentage+"%";
           
            Files.writeString(path,stats); //writes to the file   Add string for Stats
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * the function that supplies the stats data with data read from the persistence file
     * 
     * @param gamePath filepath of the persistence file
     */
    void readStats(String gamePath){
        String homeDirectory = System.getProperty("user.home");  //setting homedirectory
        String fullDirSpec = homeDirectory + "\\CardGamesGalore\\"+gamePath+".txt";  //creating a file path in a string
        Path path = Paths.get(fullDirSpec); //setting the string to a path
        try{
            stats = Files.readString(path); //setting the file contents = to a string
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
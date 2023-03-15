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
public class Player extends Hands{
    private Hands playerHand;
    
    Player(){
        playerHand= new Hands();
    }
    
    Player(Hands prebuiltHand){ //for if hand is determined before player is made
        playerHand=prebuiltHand;
    }
}

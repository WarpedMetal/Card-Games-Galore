package cggmain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

/**
 *  simple class made to hold AI's hand object (similar to Player.java and is currently not used)
 * 
 * @author chris
 */
public class AI extends Hands{
    private Hands AIHand;
    
    AI(){
        AIHand= new Hands();
    }
    
    AI(Hands prebuiltHand){ //for if hand is determined before player is made
        AIHand=prebuiltHand;
    }
}

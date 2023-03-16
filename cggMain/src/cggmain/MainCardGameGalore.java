package cggmain;

import java.util.*;

public class MainCardGameGalore {

   
    public static void main(String[] args) {
        
        System.out.println("Please select War or GoFish (w/g)");
        Scanner Scan = new Scanner(System.in);
        char gameDecision=Scan.next().charAt(0);
        // run War
        if (gameDecision == 'w'){
            War selectedGame=new War();
            selectedGame.Gameplay();
        }
        // run Go Fish
        else{
            GoFish selectedGame=new GoFish();
            selectedGame.Gameplay();
        }
        
    }
    
}

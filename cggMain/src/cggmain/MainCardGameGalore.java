import java.util.*;

public class MainCardGameGalore {

   
    public static void main(String[] args) {
        
        System.out.println("Please select War or GoFish (w/g)");
        Scanner Scan = new Scanner(System.in);
        char gameDecision=Scan.next().charAt(0);
        if (gameDecision == 'w'){
            War selectedGame=new War();
            selectedGame.Gameplay();
        }
        else{
            GoFish selectedGame=new GoFish();
        }
        
    }
    
}

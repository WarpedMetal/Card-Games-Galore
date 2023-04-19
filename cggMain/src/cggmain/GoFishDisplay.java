/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cggmain;

import java.awt.Color;
import java.awt.MouseInfo;
import java.util.Vector;
import javax.swing.JLabel;

/**
 *
 * @author jdohe/bryce
 */
public class GoFishDisplay extends javax.swing.JFrame {

    private GoFish goFishGame;
    private boolean gameOccuring;
    private boolean playerTurn;
    // the literal stuff in the player's hand
    private Hands playerHand;
    // the vector containing the modifiable JLabel objects on the GUI
    private Vector<JLabel> faceCards = new Vector<>();
    
    /**
     * Creates new form GoFishDisplay and sets up the starting hand
     */
    public GoFishDisplay() {
        initComponents();
        Color CGGGreen = new Color(0, 153, 0);
        GoFishBackground.setBackground(CGGGreen);
        this.setTitle("Card Games Galore - Go Fish");
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        goFishGame = new GoFish();
        gameOccuring = true;
        playerTurn = true;
        playerHand = goFishGame.startMatch();
        turnBox.setText("It's your turn");
        displayHand();
        String msg = "Your current number of books: 0\nThe AI's current number of books: 0\nGood luck!";
        resultBox.setText(msg);
        this.setVisible(true);
    }


    private void displayHand(){ //This will display the Player's Hand
        int x=100+(playerHand.getHand().size()-1)*40; //This is the x cord for the final card
        for(int i = 0; i < playerHand.getHand().size(); i++){ //This add all cards in the hand into a vector of JLabels
            faceCards.add(new javax.swing.JLabel());
        }
        for (int i=playerHand.getHand().size()-1; i>=0;i--){ //This sets everything up for the hand backwards so that it will display the final card on top
            faceCards.elementAt(i).setBounds(x,550,128,182);
            faceCards.elementAt(i).setText("jLabel"+(i+1));
            faceCards.elementAt(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/"+playerHand.getHand().elementAt(i)+".png")));
            GoFishBackground.add(faceCards.elementAt(i));
            x-=40;
        }
        GoFishBackground.validate();
        GoFishBackground.repaint();
    }
    
    private void removeHand(int cards){ //This function deletes the player hand from the screen
        for(int i = 0; i < cards; i++){
            GoFishBackground.remove(faceCards.elementAt(i));
        }
        GoFishBackground.validate();
        GoFishBackground.repaint();
        faceCards.clear();
    }
    
    /**
     * This function is to be called after a turn has been run through. It determines updates to the text box and visible cards
     * 
     * @param lastSize
     * @param lastAISize
     * @param lastPScore
     * @param lastAScore 
     */

    private void afterGame(int lastSize, int lastAISize, int lastPScore, int lastAScore){ //This function is called after each round to tell the player what occured
        int playerScore = goFishGame.getPlayerBooks();
        int AIScore = goFishGame.getAIBooks();
        int currSize = playerHand.getSize();
        int AISize = goFishGame.getAISize();

        displayHand();
        
        // start of textbox message stating the round's result. gives current score(s)
        String msg = "Your current number of books: " + String.valueOf(playerScore) + "\nThe AI's current number of books: " + String.valueOf(AIScore) + "\n\n";
        // if the player got a book from drawing
        if(lastPScore < playerScore && AISize == lastAISize){
            msg = msg + "You earned a book! Awesome!";
            playerTurn = false;
        }
        // if the AI got a book from drawing
        else if(lastAScore <  AIScore && currSize == lastSize){
            msg = msg + "The AI got a book :(";
            playerTurn = true;
        }
        // if the player got a book
        else if(lastPScore < playerScore){
            msg = msg + "You earned a book! Awesome!";
            playerTurn = true;
        }
        // if the AI got a book
        else if(lastAScore <  AIScore){
            msg = msg + "The AI got a book :(";
            playerTurn = false;
        }
        // if the player's hand is smaller and the ai's is bigger, it had to have taken some cards
        else if((lastSize > currSize) && (lastAISize < AISize)){
            msg = msg + "The AI took your card(s)! It gets to go again.";
            playerTurn = false;
        }
        // the opposite of the above's logic. the player took ai's cards
        else if((lastSize < currSize) && (lastAISize > AISize)){
            msg = msg + "You took the AI's card(s)!\n you get to go again.";
            playerTurn = true;
        }
        // ai didnt get any cards from the player, so had to draw
        else if((lastSize == currSize) && (lastAISize < AISize)){
            msg = msg + "The AI went fishing";
            playerTurn = true;
        }
        // player didn't get any cards from the ai, so had to draw
        else if((lastSize < currSize) && (lastAISize == AISize)){
            msg = msg + "Go Fish!";
            playerTurn = false;
        }
        resultBox.setText(msg);
        if(playerTurn){
            turnBox.setText("It's your turn");
        }
        else{
            turnBox.setText("AI's turn");
        }
        
        // Count the books to tell when the game has conlcuded
        if(goFishGame.getAIBooks() + goFishGame.getPlayerBooks() == 13){
            // Read the win value in war
            if (goFishGame.getWinVal() == 1){
                // 1 == player win
                resultBox.setText("You won! Congrats!");
                // 0 == AI win
            } else if (goFishGame.getWinVal() == 0){
                resultBox.setText("You Lost. :(");
            }
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GoFishBackground = new javax.swing.JPanel();
        aiStart = new javax.swing.JButton();
        DrawPileDeck = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultBox = new javax.swing.JTextPane();
        placeholderAIHand = new javax.swing.JLabel();
        placeholderAIHand1 = new javax.swing.JLabel();
        placeholderAIHand2 = new javax.swing.JLabel();
        placeholderAIHand3 = new javax.swing.JLabel();
        placeholderAIHand4 = new javax.swing.JLabel();
        placeholderAIHand5 = new javax.swing.JLabel();
        placeholderAIHand6 = new javax.swing.JLabel();
        BackButton1 = new javax.swing.JButton();
        turnBox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GoFishBackground.setBackground(new java.awt.Color(0, 153, 0));
        GoFishBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GoFishBackground.setPreferredSize(new java.awt.Dimension(1480, 720));
        GoFishBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GoFishBackgroundMouseClicked(evt);
            }
        });

        aiStart.setText("Start AI's turn");
        aiStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aiStartMouseClicked(evt);
            }
        });

        DrawPileDeck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        DrawPileDeck.setText("jLabel1");
        DrawPileDeck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DrawPileDeckMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(resultBox);

        placeholderAIHand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand.setText("jLabel1");

        placeholderAIHand1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand1.setText("jLabel1");

        placeholderAIHand2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand2.setText("jLabel1");

        placeholderAIHand3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand3.setText("jLabel1");

        placeholderAIHand4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand4.setText("jLabel1");

        placeholderAIHand5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand5.setText("jLabel1");

        placeholderAIHand6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        placeholderAIHand6.setText("jLabel1");

        BackButton1.setText("BACK TO MAIN MENU");
        BackButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButton1MouseClicked(evt);
            }
        });

        turnBox.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        turnBox.setForeground(new java.awt.Color(255, 255, 255));
        turnBox.setText("Turn displayed here");

        javax.swing.GroupLayout GoFishBackgroundLayout = new javax.swing.GroupLayout(GoFishBackground);
        GoFishBackground.setLayout(GoFishBackgroundLayout);
        GoFishBackgroundLayout.setHorizontalGroup(
            GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GoFishBackgroundLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GoFishBackgroundLayout.createSequentialGroup()
                        .addComponent(aiStart)
                        .addGap(481, 481, 481))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GoFishBackgroundLayout.createSequentialGroup()
                        .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                                .addComponent(placeholderAIHand4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placeholderAIHand1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placeholderAIHand, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                                .addComponent(turnBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DrawPileDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                                .addComponent(placeholderAIHand2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placeholderAIHand3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placeholderAIHand5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placeholderAIHand6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                                .addGap(345, 345, 345)
                                .addComponent(BackButton1)))
                        .addGap(117, 117, 117))))
        );
        GoFishBackgroundLayout.setVerticalGroup(
            GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeholderAIHand, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeholderAIHand1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeholderAIHand2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeholderAIHand3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeholderAIHand4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeholderAIHand5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeholderAIHand6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackButton1)
                        .addGap(386, 386, 386))
                    .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                        .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(aiStart)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DrawPileDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(turnBox))))
                        .addContainerGap(331, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GoFishBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GoFishBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DrawPileDeckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawPileDeckMouseClicked
        // TODO add your handling code here:
        System.out.print("Go fish from the draw pile.");
    }//GEN-LAST:event_DrawPileDeckMouseClicked

    private void aiStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aiStartMouseClicked
        // AI's turn:
        if(!playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(0, 0);
            removeHand(currSize);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not the AI's turn.\nYou need to do your turn");
        }
    }//GEN-LAST:event_aiStartMouseClicked

    private void BackButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        CGGMenuDisplay mainMenu = new CGGMenuDisplay();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_BackButton1MouseClicked

    //This detects any click on the background and from the cords it was clicked it can tell what card was clicked on from the vector of labels
    private void GoFishBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoFishBackgroundMouseClicked
        // TODO add your handling code here:
        int x=0, y=0, cardIndex=-1; //x cord, y cord, the index of the card that was clicked
        if (playerTurn){
            x=evt.getX();
            y=evt.getY();
            if (x<=100+(playerHand.getHand().size()-1)*40+128 && x>=100 && y<=550+182 && y>=550){ //This checks to see if the click occured within the hand
                while (x>=100){
                    x-=40;
                    cardIndex++;
                    if (cardIndex == playerHand.getHand().size()-1) break; //To fix if the final card is click not on the left side
                }
                int pScore = goFishGame.getPlayerBooks();
                int aScore = goFishGame.getAIBooks();
                int currSize = playerHand.getSize();
                int aiSize = goFishGame.getAISize();
                playerHand = goFishGame.Gameplay(cardIndex, 1);
                removeHand(currSize);
                afterGame(currSize, aiSize, pScore, aScore);
            }
        }
    }//GEN-LAST:event_GoFishBackgroundMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GoFishDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GoFishDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GoFishDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GoFishDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoFishDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton1;
    private javax.swing.JLabel DrawPileDeck;
    private javax.swing.JPanel GoFishBackground;
    private javax.swing.JButton aiStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel placeholderAIHand;
    private javax.swing.JLabel placeholderAIHand1;
    private javax.swing.JLabel placeholderAIHand2;
    private javax.swing.JLabel placeholderAIHand3;
    private javax.swing.JLabel placeholderAIHand4;
    private javax.swing.JLabel placeholderAIHand5;
    private javax.swing.JLabel placeholderAIHand6;
    private javax.swing.JTextPane resultBox;
    private javax.swing.JLabel turnBox;
    // End of variables declaration//GEN-END:variables
}

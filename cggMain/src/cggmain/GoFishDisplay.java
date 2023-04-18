/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cggmain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static cggmain.Game.faceCardImage;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        faceCards.add(playerCard1);
        faceCards.add(playerCard2);
        faceCards.add(playerCard3);
        faceCards.add(playerCard4);
        faceCards.add(playerCard5);
        faceCards.add(playerCard6);
        faceCards.add(playerCard7);
        for(int i = 0; i < 7; i++){
            faceCards.elementAt(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/"+playerHand.getHand().elementAt(i)+".png")));
        }
        String msg = "Your current number of books: 0\nThe AI's current number of books: 0\nGood luck!";
        resultBox.setText(msg);
        this.setVisible(true);
    }

    /**
     * This function is to be called after a turn has been run through. It determines updates to the text box and visible cards
     * 
     * @param lastSize
     * @param lastAISize
     * @param lastPScore
     * @param lastAScore 
     */
    private void afterGame(int lastSize, int lastAISize, int lastPScore, int lastAScore){
        int playerScore = goFishGame.getPlayerBooks();
        int AIScore = goFishGame.getAIBooks();
        int currSize = playerHand.getSize();
        int AISize = goFishGame.getAISize();
        
        // if the player's hand is smaller than 7 cards, only display the held cards
        if(currSize < 7){
            for(int i = 0; i < currSize; i++){
                faceCards.elementAt(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/"+playerHand.getHand().elementAt(i)+".png")));
                faceCards.elementAt(i).setVisible(true);
            }
            for(int i = currSize; i < 7; i++){
                faceCards.elementAt(i).setVisible(false);
            }
        }
        // otherwise only display the first 7 cards in their hand
        else
        {
            for(int i = 0; i < 7; i++){
                faceCards.elementAt(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/"+playerHand.getHand().elementAt(i)+".png")));
                faceCards.elementAt(i).setVisible(true);
            }
        }
        
        // start of textbox message stating the round's result. gives current score(s)
        String msg = "Your current number of books: " + String.valueOf(playerScore) + "\nThe AI's current number of books: " + String.valueOf(AIScore) + "\n\n";
        // if the player got a book
        if(lastPScore < playerScore){
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
        playerCard1 = new javax.swing.JLabel();
        playerCard2 = new javax.swing.JLabel();
        playerCard3 = new javax.swing.JLabel();
        playerCard4 = new javax.swing.JLabel();
        playerCard5 = new javax.swing.JLabel();
        playerCard6 = new javax.swing.JLabel();
        playerCard7 = new javax.swing.JLabel();
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

        playerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard1.setText("jLabel1");
        playerCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard1MouseClicked(evt);
            }
        });

        playerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard2.setText("jLabel2");
        playerCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard2MouseClicked(evt);
            }
        });

        playerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard3.setText("jLabel3");
        playerCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard3MouseClicked(evt);
            }
        });

        playerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard4.setText("jLabel4");
        playerCard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard4MouseClicked(evt);
            }
        });

        playerCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard5.setText("jLabel5");
        playerCard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard5MouseClicked(evt);
            }
        });

        playerCard6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard6.setText("jLabel4");
        playerCard6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard6MouseClicked(evt);
            }
        });

        playerCard7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/27.png"))); // NOI18N
        playerCard7.setText("jLabel4");
        playerCard7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerCard7MouseClicked(evt);
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
        turnBox.setText("Turn displayed here");

        javax.swing.GroupLayout GoFishBackgroundLayout = new javax.swing.GroupLayout(GoFishBackground);
        GoFishBackground.setLayout(GoFishBackgroundLayout);
        GoFishBackgroundLayout.setHorizontalGroup(
            GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GoFishBackgroundLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(playerCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playerCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playerCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playerCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playerCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playerCard6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playerCard7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GoFishBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(180, 180, 180))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)))
                .addGroup(GoFishBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerCard1)
                    .addComponent(playerCard2)
                    .addComponent(playerCard3)
                    .addComponent(playerCard4)
                    .addComponent(playerCard5)
                    .addComponent(playerCard7)
                    .addComponent(playerCard6))
                .addGap(24, 24, 24))
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
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not the AI's turn.\nYou need to do your turn");
        }
    }//GEN-LAST:event_aiStartMouseClicked

    private void playerCard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard1MouseClicked
        // Player's turn (chose card 1):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(0, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard1MouseClicked

    private void playerCard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard2MouseClicked
        // Player's turn (chose card 2):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(1, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard2MouseClicked

    private void playerCard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard3MouseClicked
        // Player's turn (chose card 3):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(2, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard3MouseClicked

    private void playerCard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard4MouseClicked
        // Player's turn (chose card 4):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(3, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard4MouseClicked

    private void playerCard5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard5MouseClicked
        // Player's turn (chose card 5):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(4, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard5MouseClicked

    private void playerCard6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard6MouseClicked
        // Player's turn (chose card 6):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(5, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard6MouseClicked

    private void playerCard7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerCard7MouseClicked
        // Player's turn (chose card 7):
        if(playerTurn){
            int pScore = goFishGame.getPlayerBooks();
            int aScore = goFishGame.getAIBooks();
            int currSize = playerHand.getSize();
            int aiSize = goFishGame.getAISize();
            playerHand = goFishGame.Gameplay(6, 1);
            afterGame(currSize, aiSize, pScore, aScore);
        }
        else{
            resultBox.setText("It's not your turn.\nThe AI needs to do its turn");
        }
    }//GEN-LAST:event_playerCard7MouseClicked

    private void BackButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        CGGMenuDisplay mainMenu = new CGGMenuDisplay();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_BackButton1MouseClicked

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
    private javax.swing.JLabel playerCard1;
    private javax.swing.JLabel playerCard2;
    private javax.swing.JLabel playerCard3;
    private javax.swing.JLabel playerCard4;
    private javax.swing.JLabel playerCard5;
    private javax.swing.JLabel playerCard6;
    private javax.swing.JLabel playerCard7;
    private javax.swing.JTextPane resultBox;
    private javax.swing.JLabel turnBox;
    // End of variables declaration//GEN-END:variables
}

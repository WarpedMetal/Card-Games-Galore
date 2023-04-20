/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cggmain;

import static cggmain.Game.faceCardImage;


/**
 * main handler for War's GUI display
 * 
 * @author jdohe/chris/bryce
 */
public class WarDisplay extends javax.swing.JFrame {

    private War warGame;
    private boolean GameOccuring;
    
    /**
     * Creates new form WarDisplay
     */
    public WarDisplay() {
        initComponents();
        AIFaceCard.setVisible(false);
        PlayerFaceCard.setVisible(false);
        warGame=new War();
        GameOccuring=true;
        this.setTitle("Card Games Galore - War");
        this.setSize(850, 600);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AIDeck = new javax.swing.JLabel();
        PlayerDeck = new javax.swing.JLabel();
        PlayerFaceCard = new javax.swing.JLabel();
        AIFaceCard = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultBox = new javax.swing.JTextPane();
        PlayerLabel = new javax.swing.JLabel();
        OpponentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        AIDeck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        AIDeck.setText("jLabel1");

        PlayerDeck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        PlayerDeck.setText("jLabel1");
        PlayerDeck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayerDeckMouseClicked(evt);
            }
        });

        PlayerFaceCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/10.png"))); // NOI18N
        PlayerFaceCard.setText("Didn't Work");
        PlayerFaceCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayerFaceCardMouseClicked(evt);
            }
        });

        AIFaceCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CardBackResize25.png"))); // NOI18N
        AIFaceCard.setText("jLabel1");

        BackButton.setText("BACK TO MAIN MENU");
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(ResultBox);

        PlayerLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        PlayerLabel.setForeground(new java.awt.Color(255, 255, 255));
        PlayerLabel.setText("AI Opponent");

        OpponentLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        OpponentLabel.setForeground(new java.awt.Color(255, 255, 255));
        OpponentLabel.setText("Player 1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlayerLabel)
                    .addComponent(OpponentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AIDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AIFaceCard, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerFaceCard, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AIDeck)
                            .addComponent(AIFaceCard)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton)
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(PlayerLabel)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(PlayerDeck)
                        .addContainerGap(9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OpponentLabel)
                        .addGap(115, 115, 115))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(PlayerFaceCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * on call, runs a single gameplay loop of a War round
     * 
     * @param evt 
     */
    private void PlayerDeckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayerDeckMouseClicked
        // TODO add your handling code here:
        System.out.println("Player deck clicked.");
        if (GameOccuring){
            int playerCard=warGame.getPlayerCard();
            int AICard=warGame.getAICard();
            warGame.Gameplay();
            GameOccuring=warGame.getGamePlaying();
            System.out.println("/FaceCards/"+playerCard+".png");
            PlayerFaceCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/"+playerCard+".png")));
            PlayerFaceCard.setVisible(true);
            //PlayerFaceCard.setLabelFor(PlayerFaceCard);
            //PlayerFaceCard.setVisible(true);
            AIFaceCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FaceCards/"+AICard+".png")));
            AIFaceCard.setVisible(true);
            int playerCardValue = playerCard;
            int AICardValue = AICard;
            // Made a seperate variable for counting so as not to mess with the actual card values
            // Find the value of the cards based on the definition/set up in war
            // Using a while to subtract 13 until it gets to a comparable number 2-14
            while (playerCardValue > 14){
                playerCardValue = playerCardValue - 13;
            }
            while (AICardValue > 14){
                AICardValue = AICardValue - 13;
            }
            // Print the results to the GUI result box
            if (playerCardValue > AICardValue ){
                ResultBox.setText("You won!");
            }else if (playerCardValue < AICardValue){
                ResultBox.setText("You lost this round.");
            }else{
                ResultBox.setText("This is war!");
            }
        }
        else{
            //return them to the main menu after telling them that they won or lost
            
        }
        // if the user leaves, dispose of the frame containing the war game
        setDefaultCloseOperation(WarDisplay.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_PlayerDeckMouseClicked

    private void PlayerFaceCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayerFaceCardMouseClicked
        // TODO add your handling code here:
        System.out.println("Player face card clicked");
  
        
    }//GEN-LAST:event_PlayerFaceCardMouseClicked

    /**
     * upon quitting from the game (not by hitting the 'x'), close the display and bring back the main menu
     * 
     * @param evt 
     */
    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
        CGGMenuDisplay mainMenu = new CGGMenuDisplay();
        mainMenu.setVisible(true);
        
    }//GEN-LAST:event_BackButtonMouseClicked

   
    
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
            java.util.logging.Logger.getLogger(WarDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WarDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WarDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WarDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WarDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AIDeck;
    private javax.swing.JLabel AIFaceCard;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel OpponentLabel;
    private javax.swing.JLabel PlayerDeck;
    private javax.swing.JLabel PlayerFaceCard;
    private javax.swing.JLabel PlayerLabel;
    private javax.swing.JTextPane ResultBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cggmain;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *  main menu display that starts up on program run. point of beginning
 * 
 * @author jdohe
 */
public class CGGMenuDisplay extends javax.swing.JFrame {

    /**
     * Creates new form CGGMenuDisplay
     */
    public CGGMenuDisplay() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 700);
    }
    

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        jComboBox2 = new javax.swing.JComboBox<>();
        jButtonPlay = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelMenuTitle = new javax.swing.JLabel();
        jLabelMenuDescribe = new javax.swing.JLabel();
        jButtonHighScore = new javax.swing.JButton();
        jButtonQuit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonRules = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Card Games Galore - Main Menu");

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 5, true));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "War", "Go Fish" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButtonPlay.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonPlay.setText("PLAY");
        jButtonPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPlayMouseClicked(evt);
            }
        });

        jLabelMenuTitle.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabelMenuTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuTitle.setText("CARD GAMES GALORE");

        jLabelMenuDescribe.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelMenuDescribe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenuDescribe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenuDescribe.setText("Please select from the menu options below. ");

        jButtonHighScore.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonHighScore.setText("HIGH SCORES");
        jButtonHighScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHighScoreActionPerformed(evt);
            }
        });

        jButtonQuit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonQuit.setText("QUIT");
        jButtonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageResources/Card Games Galore Resources/CGGMenuImage.png"))); // NOI18N

        jButtonRules.setText("RULES");
        jButtonRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRulesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonRules)
                                .addGap(61, 61, 61)
                                .addComponent(jButtonHighScore))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonQuit))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabelMenuTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabelMenuDescribe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelMenuTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabelMenuDescribe)
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuit)
                    .addComponent(jButtonPlay))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHighScore)
                    .addComponent(jButtonRules))
                .addGap(115, 115, 115))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitActionPerformed
        // TODO add your handling code here:
        // Exit on button click for Quit
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitActionPerformed

    /**
     * loads a debug statement to help specify which game was chosen in the GUI
     * 
     * @param evt 
     */
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        // listen for user selection from list of games
        String gameSelection = (String) jComboBox2.getSelectedItem();
       // System.out.println("Selection is: " + gameSelection);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * upon clicking the "start" button, this function starts the respective game's core gameplay loop
     * 
     * @param evt 
     */
    private void jButtonPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPlayMouseClicked
        // TODO add your handling code here:
        if (jComboBox2.getSelectedItem() == "War"){
            WarDisplay newWarGame=new WarDisplay();
            newWarGame.setVisible(true);
            this.setVisible(false);}
        if (jComboBox2.getSelectedItem() == "Go Fish"){
           // System.out.print("Go Fish?");
            GoFishDisplay newGoFishGame=new GoFishDisplay();
            newGoFishGame.setVisible(true);
            this.setVisible(false);
      }
    }//GEN-LAST:event_jButtonPlayMouseClicked

    /**
     * This function is used to specify a specific game's rules in a pop-up window
     * 
     * @param evt 
     */
    private void jButtonRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRulesActionPerformed
        // TODO add your handling code here:
        if (jComboBox2.getSelectedItem() == "War"){
            War warRules=new War();
            warRules.setRules("War is a pretty basic game, where 2 players are playing against each other. \n"  //The rules for War
                + "Each player gets half of the deck but can not look at them. They then play \n"
                + "one card at a time and whoever had the higher card (Ace high) wins the cards \n"
                + "The winnner then puts those cards on the bottom of their deck and play continues \n"
                + "until only one player has any cards. The only exception to this is if the players \n"
                + "tie. In which they then lay down their top 3 cards face down and play one final \n"
                + "card face up. Whoever wins that hand wins every card that was played. The face \n"
                + "down and face up cards. Whoever gets the whole deck first wins.");
            showMessageDialog(null,warRules.getRules());
        }
        else if (jComboBox2.getSelectedItem() == "Go Fish"){
            GoFish goFishRules=new GoFish();
            goFishRules.setRules("Go Fish is a game that is played between 2 people. The start \n"    //The rules fo Go Fish
                    + "of the game involves both players getting dealt a hand of 7 cards. \n"
                    + "The objective of the game is to get the most 4 of a kinds (4 cards \n"
                    + "of the same variety). On your turn you will pick a card that you would \n"
                    + "like to steal from your opponent. Whatever card you pick you will then \n"
                    + "steal all of the same cards that they have. For example, if you pick 10 \n"
                    + "and they have 2 10s you will steal both of their 10s. You continue playing\n"
                    + "until you fail to steal a card from them. Then, you draw one card from the \n"
                    + "deck. When you get a 4 of a kind you set it down and continue playing \n"
                    + "until all the cards are used up. At the end whoever has the most 4 of a \n"
                    + "kinds wins.\n");
            showMessageDialog(null,goFishRules.getRules());
        }
    }//GEN-LAST:event_jButtonRulesActionPerformed

    /**
     * this function retrieves the persistent stats of a player related to a specific game
     * 
     * @param evt 
     */
    private void jButtonHighScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHighScoreActionPerformed
        // TODO add your handling code here:
         if (jComboBox2.getSelectedItem() == "War"){
            War warStats=new War();
            String homeDirectory = System.getProperty("user.home");  //setting homedirectory
            if (!Files.exists(Paths.get(homeDirectory+"\\\\CardGamesGalore\\WarStats.txt"))) {   //To check if they have played before
                showMessageDialog(null,"You have not played War yet!");
            } 
            else {
                warStats.readStats("WarStats");
                showMessageDialog(null,warStats.getStats());  //Showing stats to screen
            }
        }
        else if (jComboBox2.getSelectedItem() == "Go Fish"){
            GoFish goFishStats=new GoFish();
            String homeDirectory = System.getProperty("user.home");  //setting homedirectory
            if (!Files.exists(Paths.get(homeDirectory+"\\\\CardGamesGalore\\GoFishStats.txt"))) {   //To check if they have played before
                showMessageDialog(null,"You have not played Go Fish yet!");
            } 
            else {
                goFishStats.readStats("GoFishStats");
                showMessageDialog(null,goFishStats.getStats());   //Showing stats to screen
            }
        }
    }//GEN-LAST:event_jButtonHighScoreActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(CGGMenuDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CGGMenuDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CGGMenuDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CGGMenuDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CGGMenuDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHighScore;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonQuit;
    private javax.swing.JButton jButtonRules;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMenuDescribe;
    private javax.swing.JLabel jLabelMenuTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

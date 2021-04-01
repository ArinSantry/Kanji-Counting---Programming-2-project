/*
 * TreasureHunt.java, KanjiCounting, Team Millennium.
 * Play treasure hunt minigame.
 */
package KanjiCounting;

import java.util.Random;
import java.awt.Font;
import java.io.InputStream;
import javax.swing.JOptionPane;


/**
 *
 * @author hdren
 */
public class TreasureHunt extends javax.swing.JFrame {

    // the following variables are used for displaying the kanji charracters
    private Font kanji;
    private final String ZERO = "" + '\u96F6';
    private final String ONE = "" + '\u4E00';
    private final String TWO = "" + '\u4E8C';
    private final String THREE = "" + '\u4E09';
    private final String FOUR = "" + '\u56DB';
    private final String FIVE = "" + '\u4E94';
    private final String SIX = "" + '\u516D';
    private final String SEVEN = "" + '\u4E03';
    private final String EIGHT = "" + '\u516B';
    private final String NINE = "" + '\u4E5D';
    private final String TEN = "" + '\u5341';
    private final String HUNDRED = "" + '\u767e';
    
    // the rest of the varaiables are used for the logic of the game
    private Random rnd = new Random();
    private int correctPath;
    private String correctPathK;
    private int wrongPath1;
    private String wrongPath1K;
    private int wrongPath2;
    private String wrongPath2K;
    private int[] level;
    private int arraySize;
    private int stepsToTreas;
    private int progress = 0;
    private int ropes;
    /**
     * Creates new form TreasureHunt
     */
    public TreasureHunt() {
        initComponents();
        
        // the following code is used to create the font needed to display the characters
        try
        {
            InputStream fontStream = TreasureHunt.class.getResourceAsStream("/kanji-font1.ttf");
            Font onePoint = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            fontStream.close();
            kanji = onePoint.deriveFont(Font.PLAIN, 15);
        }
        catch (Exception e) {}
        nChar.setFont(kanji);
        wChar.setFont(kanji);
        eChar.setFont(kanji);
        
        openingDialog.setVisible(true);
    }
    
    public void TreasureHunt(int level[]) {
        this.level = level;
        arraySize = this.level.length;
        if (arraySize == 11){
            stepsToTreas = this.level.length;
            ropes = 4;
        }
        else {
            stepsToTreas = 20;
            ropes = 9;
            progressBar.setMaximum(20);
        }
        livesLabel.setText("" + ropes);
        playGame();
    }
    
    private void playGame() {
        if (ropes < 0) {
            gameLost();
        }
        if (stepsToTreas == progress) { // the check to see if they made it to the treasure
            gameWon();
        }
        
        createPaths();
        correctPathK = createPathK(correctPath);
        wrongPath1K = createPathK(wrongPath1);
        wrongPath2K = createPathK(wrongPath2);
        
        // the switch statement is used to assign which of the three paths are correct and which are not
        switch(rnd.nextInt(3)) { 
            // the random number is used to  make sure the user doesn't memorize the path
            case 0: wChar.setText(correctPathK);
                    nChar.setText(wrongPath1K);
                    eChar.setText(wrongPath2K);
                    break;
            case 1: nChar.setText(correctPathK);
                    eChar.setText(wrongPath1K);
                    wChar.setText(wrongPath2K);
                    break;
            case 2: eChar.setText(correctPathK);
                    wChar.setText(wrongPath1K);
                    nChar.setText(wrongPath2K);
                    break;
        }       
        messageDisplay.setText("The map says that the correct path has " + correctPath + " paces.\nWhich path is it?");
    }
    
    private void createPaths() {
        // random path lengths are generated say the player can't just memorize the path
        if (arraySize == 11 && level[level.length - 1] == 100) { 
            // this if statement is used to accomadate level 2's numbers
            correctPath = rnd.nextInt(arraySize) * 10;
            // the following do while loops are used so that each path will guranteed have a different set of steps
            do {
                wrongPath1 = rnd.nextInt(arraySize) * 10;
            } while(correctPath == wrongPath1); 
            do {
                wrongPath2 = rnd.nextInt(arraySize) * 10;
            } while(correctPath == wrongPath2 || wrongPath1 == wrongPath2);
        }
        else { // this else block will be used for level 1 and 3
            correctPath = rnd.nextInt(arraySize);
            // the following do while loops are used so that each path will guranteed have a different set of steps
            do {
                wrongPath1 = rnd.nextInt(arraySize);
            } while(correctPath == wrongPath1);
            do {
                wrongPath2 = rnd.nextInt(arraySize);
            } while(correctPath == wrongPath2);
        }
    }
    
    private String createPathK(int path) {
        String pathK = "";
        if (path == 100) pathK = HUNDRED;
        else if(100 > path && path > 10){
            switch (path / 10) {
                case 1: pathK = TEN; break;
                case 2: pathK = TWO + TEN; break;
                case 3: pathK = THREE + TEN; break;
                case 4: pathK = FOUR + TEN; break;
                case 5: pathK = FIVE + TEN; break;
                case 6: pathK = SIX + TEN; break;
                case 7: pathK = SEVEN + TEN; break;
                case 8: pathK = EIGHT + TEN; break;
                case 9: pathK = NINE + TEN; break;
            }
            switch (path % 10) {
                case 0: break;
                case 1: pathK += ONE; break;
                case 2: pathK += TWO; break;
                case 3: pathK += THREE; break;
                case 4: pathK += FOUR; break;
                case 5: pathK += FIVE; break;
                case 6: pathK += SIX; break;
                case 7: pathK += SEVEN; break;
                case 8: pathK += EIGHT; break;
                case 9: pathK += NINE; break;
            }
        }
        else {
            switch (path) {
                case 0: pathK = ZERO; break;
                case 1: pathK = ONE; break;
                case 2: pathK = TWO; break;
                case 3: pathK = THREE; break;
                case 4: pathK = FOUR; break;
                case 5: pathK = FIVE; break;
                case 6: pathK = SIX; break;
                case 7: pathK = SEVEN; break;
                case 8: pathK = EIGHT; break;
                case 9: pathK = NINE; break;
                case 10: pathK = TEN; break;
            }
        }
        return pathK;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openingDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        continueButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageDisplay = new javax.swing.JTextArea();
        nChar = new javax.swing.JButton();
        eChar = new javax.swing.JButton();
        wChar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        livesLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();

        openingDialog.setLocation(new java.awt.Point(700, 200));
        openingDialog.setSize(new java.awt.Dimension(400, 325));

        jLabel1.setText("Welcome to the Treasure Hunt");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("The map will tell you how many paces it will take to get to the next spot and you have to translate the Kanji characters on the signs to go the correct way. But watch out, if you go the wrong way you might fall into a sand trap");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        continueButton.setText("Continue");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout openingDialogLayout = new javax.swing.GroupLayout(openingDialog.getContentPane());
        openingDialog.getContentPane().setLayout(openingDialogLayout);
        openingDialogLayout.setHorizontalGroup(
            openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, openingDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(openingDialogLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(openingDialogLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(continueButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        openingDialogLayout.setVerticalGroup(
            openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openingDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(continueButton)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Game Pics/treausre map.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Treasure Hunt");
        setLocation(new java.awt.Point(700, 200));
        setMaximumSize(new java.awt.Dimension(410, 320));
        setMinimumSize(new java.awt.Dimension(410, 320));
        setPreferredSize(new java.awt.Dimension(410, 320));
        setSize(new java.awt.Dimension(410, 320));
        getContentPane().setLayout(null);

        messageDisplay.setEditable(false);
        messageDisplay.setColumns(20);
        messageDisplay.setLineWrap(true);
        messageDisplay.setRows(5);
        messageDisplay.setWrapStyleWord(true);
        messageDisplay.setOpaque(false);
        jScrollPane2.setViewportView(messageDisplay);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(124, 174, 166, 96);

        nChar.setOpaque(false);
        nChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nCharActionPerformed(evt);
            }
        });
        getContentPane().add(nChar);
        nChar.setBounds(161, 96, 85, 60);

        eChar.setOpaque(false);
        eChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCharActionPerformed(evt);
            }
        });
        getContentPane().add(eChar);
        eChar.setBounds(308, 197, 85, 60);

        wChar.setOpaque(false);
        wChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wCharActionPerformed(evt);
            }
        });
        getContentPane().add(wChar);
        wChar.setBounds(21, 191, 85, 60);

        jLabel2.setText("Ropes:");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 110, 50, 20);

        livesLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        getContentPane().add(livesLabel);
        livesLabel.setBounds(70, 130, 50, 31);

        progressBar.setMaximum(10);
        getContentPane().add(progressBar);
        progressBar.setBounds(74, 47, 256, 14);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Game Pics/treausre map.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 410, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        // TODO add your handling code here:
        openingDialog.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_continueButtonActionPerformed

    private void nCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nCharActionPerformed
        // TODO add your handling code here:
        if (nChar.getText() == correctPathK) {
            progress++;
            progressBar.setValue(progress);
            playGame();
        }
        else {
            ropes--;
            livesLabel.setText("" + ropes);
            messageDisplay.append("\n\n\nOh no, you went the wrong way and fell into a sand trap. Try again.");
        }
    }//GEN-LAST:event_nCharActionPerformed

    private void wCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wCharActionPerformed
        // TODO add your handling code here:
        if (wChar.getText() == correctPathK) {
            progress++;
            progressBar.setValue(progress);
            playGame();
        }
        else {
            ropes--;
            livesLabel.setText("" + ropes);
            messageDisplay.append("\nOh no, you went the wrong way and fell into a sand trap. Try again.");
        }
    }//GEN-LAST:event_wCharActionPerformed

    private void eCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCharActionPerformed
        // TODO add your handling code here:
        if (eChar.getText() == correctPathK) {
            progress++;
            progressBar.setValue(progress);
            playGame();
        }
        else {
            ropes--;
            livesLabel.setText("" + ropes);
            messageDisplay.append("\nOh no, you went the wrong way and fell into a sand trap. Try again.");
        }
    }//GEN-LAST:event_eCharActionPerformed

    private void gameWon() {
        JOptionPane.showMessageDialog( null, "you won");
    }
    
    private void gameLost() {
        JOptionPane.showMessageDialog( null, "you lost");
    }
    
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
            java.util.logging.Logger.getLogger(TreasureHunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreasureHunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreasureHunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreasureHunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreasureHunt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continueButton;
    private javax.swing.JButton eChar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel livesLabel;
    private javax.swing.JTextArea messageDisplay;
    private javax.swing.JButton nChar;
    private javax.swing.JDialog openingDialog;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton wChar;
    // End of variables declaration//GEN-END:variables
}

/*
 * Flashcards.java, KanjiCounting, Team Millennium
 * Play the Flashcard game.
 */
package KanjiCounting;

import java.awt.Font;
import java.io.InputStream;
import java.util.Random;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Millennium
 */
public class Flashcards extends javax.swing.JFrame {

    private Font kanji; // font to allow Kanji letters/numbers
    // 101 lines of variables - set kanji unicode characters
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
    private final String ELEVEN = TEN + ONE;
    private final String TWELVE = TEN + TWO;
    private final String THIRTEEN = TEN + THREE;
    private final String FOURTEEN = TEN + FOUR;
    private final String FIFTEEN = TEN + FIVE;
    private final String SIXTEEN = TEN + SIX;
    private final String SEVENTEEN = TEN + SEVEN;
    private final String EIGHTEEN = TEN + EIGHT;
    private final String NINETEEN = TEN + NINE;
    private final String TWENTY = TWO + TEN;
    private final String TWENTYONE = TWENTY + ONE;
    private final String TWENTYTWO = TWENTY + TWO;
    private final String TWENTYTHREE = TWENTY + THREE;
    private final String TWENTYFOUR = TWENTY + FOUR;
    private final String TWENTYFIVE = TWENTY + FIVE;
    private final String TWENTYSIX = TWENTY + SIX;
    private final String TWENTYSEVEN = TWENTY + SEVEN;
    private final String TWENTYEIGHT = TWENTY + EIGHT;
    private final String TWENTYNINE = TWENTY + NINE;
    private final String THIRTY = THREE + TEN;
    private final String THIRTYONE = THIRTY + ONE;
    private final String THIRTYTWO = THIRTY + TWO;
    private final String THIRTYTHREE = THIRTY + THREE;
    private final String THIRTYFOUR = THIRTY + FOUR;
    private final String THIRTYFIVE = THIRTY + FIVE;
    private final String THIRTYSIX = THIRTY + SIX;
    private final String THIRTYSEVEN = THIRTY + SEVEN;
    private final String THIRTYEIGHT = THIRTY + EIGHT;
    private final String THRITYNINE = THIRTY + NINE;
    private final String FOURTY = FOUR + TEN;
    private final String FOURTYONE = FOURTY + ONE;
    private final String FOURTYTWO = FOURTY + TWO;
    private final String FOURTYTHREE = FOURTY + THREE;
    private final String FOURTYFOUR = FOURTY + FOUR;
    private final String FOURTYFIVE = FOURTY + FIVE;
    private final String FOURTYSIX = FOURTY + SIX;
    private final String FOURTYSEVEN = FOURTY + SEVEN;
    private final String FOURTYEIGHT = FOURTY + EIGHT;
    private final String FOURTYNINE = FOURTY + NINE;
    private final String FIFTY = FIVE + TEN;
    private final String FIFTYONE = FIFTY + ONE;
    private final String FIFTYTWO = FIFTY + TWO;
    private final String FIFTYTHREE = FIFTY + THREE;
    private final String FIFTYFOUR = FIFTY + FOUR;
    private final String FIFTYFIVE = FIFTY + FIVE;
    private final String FIFTYSIX = FIFTY + SIX;
    private final String FIFTYSEVEN = FIFTY + SEVEN;
    private final String FIFTYEIGHT = FIFTY + EIGHT;
    private final String FIFTYNINE = FIFTY + NINE;
    private final String SIXTY = SIX + TEN;
    private final String SIXTYONE = SIXTY + ONE;
    private final String SIXTYTWO = SIXTY + TWO;
    private final String SIXTYTHREE = SIXTY + THREE;
    private final String SIXTYFOUR = SIXTY + FOUR;
    private final String SIXTYFIVE = SIXTY + FIVE;
    private final String SIXTYSIX = SIXTY + SIX;
    private final String SIXTYSEVEN = SIXTY + SEVEN;
    private final String SIXTYEIGHT = SIXTY + EIGHT;
    private final String SIXTYNINE = SIXTY + NINE; // nice
    private final String SEVENTY = SEVEN + TEN;
    private final String SEVENTYONE = SEVENTY + TEN + ONE;
    private final String SEVENTYTWO = SEVENTY + TWO;
    private final String SEVENTYTHREE = SEVENTY + THREE;
    private final String SEVENTYFOUR = SEVENTY + FOUR;
    private final String SEVENTYFIVE = SEVENTY + FIVE;
    private final String SEVENTYSIX = SEVENTY + SIX;
    private final String SEVENTYSEVEN = SEVENTY + SEVEN;
    private final String SEVENTYEIGHT = SEVENTY + EIGHT;
    private final String SEVENTYNINE = SEVENTY + NINE;
    private final String EIGHTY = EIGHT + TEN;
    private final String EIGHTYONE = EIGHTY + ONE;
    private final String EIGHTYTWO = EIGHTY + TWO;
    private final String EIGHTYTHREE = EIGHTY + THREE;
    private final String EIGHTYFOUR = EIGHTY + FOUR;
    private final String EIGHTYFIVE = EIGHTY + FIVE;
    private final String EIGHTYSIX = EIGHTY + SIX;
    private final String EIGHTYSEVEN = EIGHTY + SEVEN;
    private final String EIGHTYEIGHT = EIGHTY + EIGHT;
    private final String EIGHTYNINE = EIGHTY + NINE;
    private final String NINETY = NINE + TEN;
    private final String NINETYONE = NINETY + ONE;
    private final String NINETYTWO = NINETY + TWO;
    private final String NINETYTHREE = NINETY + THREE;
    private final String NINETYFOUR = NINETY + FOUR;
    private final String NINETYFIVE = NINETY + FIVE;
    private final String NINETYSIX = NINETY + SIX;
    private final String NINETYSEVEN = NINETY + SEVEN;
    private final String NINETYEIGHT = NINETY + EIGHT;
    private final String NINETYNINE = NINETY + NINE;
    private final String ONEHUNDRED = "" + '\u767E';
    private int answer;
    private int guess;
    private int score = 0;
    private int level;
    MainMenu mainMenu = new MainMenu();
    
    /**
     * Creates new form Flashcards
     */
    public Flashcards() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color (51,153,255));
        
        // set up Kanji font
        try
        {
            InputStream fontStream = CountingGame.class.getResourceAsStream("/kanji-font1.ttf");
            Font onePoint = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            fontStream.close();
            kanji = onePoint.deriveFont(Font.PLAIN, 200);
        }
        catch (Exception e) {} // make Netbeans happy
        
        kanjiLabel.setFont(kanji);
        
        // initialize the Kanji number shown and level selected
        kanjiLabel.setText(ZERO);
        setLevel();
        
        // hide the next button
        nextButton.setVisible(false);
    }
    
    /**
     * Retrieve level from the level combo box.
     */
    public void setLevel()
    {
        level = Integer.parseInt(levelComboBox.getSelectedItem().toString());
    }
    
    /**
     * Choose a random number to be shown as the answer.
     * Changes with level selected.
     * Level 1 = numbers 0-10
     * Level 2 = tens (0, 10, 20, etc.)
     * Level 3= all numbers 0-100
     * @return int answer
     */
    public int setAnswer()
    {
        Random rand = new Random();
        switch (level) 
        {
            case 1:
                answer = rand.nextInt(11); // random number 0-10
                break;
            case 2:
                answer = rand.nextInt(11) * 10; // random number 0, 10, 20, 30, etc.
                break;
            case 3:
                answer = rand.nextInt(101); // random number 0-100
                break;
            default:
                break;
        }
        setKanji(answer);
        return answer;
    }
    
    /**
     * Show number that has been randomly chosen as Kanji.
     * @param num generated by setAnswer()
     */
    public void setKanji(int num)
    {
        // I'm sure there's a way to do this that isn't 300 lines long
        // but we're doing this
        switch(num)
        {
            case 0:
                kanjiLabel.setText(ZERO);
                break;
            case 1:
                kanjiLabel.setText(ONE);
                break;
            case 2:
                kanjiLabel.setText(TWO);
                break;
            case 3:
                kanjiLabel.setText(THREE);
                break;
            case 4:
                kanjiLabel.setText(FOUR);
                break;
            case 5:
                kanjiLabel.setText(FIVE);
                break;
            case 6:
                kanjiLabel.setText(SIX);
                break;
            case 7:
                kanjiLabel.setText(SEVEN);
                break;
            case 8:
                kanjiLabel.setText(EIGHT);
                break;
            case 9:
                kanjiLabel.setText(NINE);
                break;
            case 10:
                kanjiLabel.setText(TEN);
                break;
            case 11:
                kanjiLabel.setText(ELEVEN);
                break;
            case 12:
                kanjiLabel.setText(TWELVE);
                break;
            case 13:
                kanjiLabel.setText(THIRTEEN);
                break;
            case 14:
                kanjiLabel.setText(FOURTEEN);
                break;
            case 15:
                kanjiLabel.setText(FIFTEEN);
                break;
            case 16:
                kanjiLabel.setText(SIXTEEN);
                break;
            case 17:
                kanjiLabel.setText(SEVENTEEN);
                break;
            case 18:
                kanjiLabel.setText(EIGHTEEN);
                break;
            case 19:
                kanjiLabel.setText(NINETEEN);
                break;
            case 20:
                kanjiLabel.setText(TWENTY);
                break;
            case 21:
                kanjiLabel.setText(TWENTYONE);
                break;
            case 22:
                kanjiLabel.setText(TWENTYTWO);
                break;
            case 23:
                kanjiLabel.setText(TWENTYTHREE);
                break;
            case 24:
                kanjiLabel.setText(TWENTYFOUR);
                break;
            case 25:
                kanjiLabel.setText(TWENTYFIVE);
                break;
            case 26:
                kanjiLabel.setText(TWENTYSIX);
                break;
            case 27:
                kanjiLabel.setText(TWENTYSEVEN);
                break;
            case 28:
                kanjiLabel.setText(TWENTYEIGHT);
                break;
            case 29:
                kanjiLabel.setText(TWENTYNINE);
                break;
            case 30:
                kanjiLabel.setText(THIRTY);
                break;
            case 31:
                kanjiLabel.setText(THIRTYONE);
                break;
            case 32:
                kanjiLabel.setText(THIRTYTWO);
                break;
            case 33:
                kanjiLabel.setText(THIRTYTHREE);
                break;
            case 34:
                kanjiLabel.setText(THIRTYFOUR);
                break;
            case 35:
                kanjiLabel.setText(THIRTYFIVE);
                break;
            case 36:
                kanjiLabel.setText(THIRTYSIX);
                break;
            case 37:
                kanjiLabel.setText(THIRTYSEVEN);
                break;
            case 38:
                kanjiLabel.setText(THIRTYEIGHT);
                break;
            case 39:
                kanjiLabel.setText(THRITYNINE);
                break;
            case 40:
                kanjiLabel.setText(FOURTY);
                break;
            case 41:
                kanjiLabel.setText(FOURTYONE);
                break;
            case 42:
                kanjiLabel.setText(FOURTYTWO);
                break;
            case 43:
                kanjiLabel.setText(FOURTYTHREE);
                break;
            case 44:
                kanjiLabel.setText(FOURTYFOUR);
                break;
            case 45:
                kanjiLabel.setText(FOURTYFIVE);
                break;
            case 46:
                kanjiLabel.setText(FOURTYSIX);
                break;
            case 47:
                kanjiLabel.setText(FOURTYSEVEN);
                break;
            case 48:
                kanjiLabel.setText(FOURTYEIGHT);
                break;
            case 49:
                kanjiLabel.setText(FOURTYNINE);
                break;
            case 50:
                kanjiLabel.setText(FIFTY);
                break;
            case 51: 
                kanjiLabel.setText(FIFTYONE);
                break;
            case 52:
                kanjiLabel.setText(FIFTYTWO);
                break;
            case 53:
                kanjiLabel.setText(FIFTYTHREE);
                break;
            case 54:
                kanjiLabel.setText(FIFTYFOUR);
                break;
            case 55:
                kanjiLabel.setText(FIFTYFIVE);
                break;
            case 56:
                kanjiLabel.setText(FIFTYSIX);
                break;
            case 57:
                kanjiLabel.setText(FIFTYSEVEN);
                break;
            case 58:
                kanjiLabel.setText(FIFTYEIGHT);
                break;
            case 59:
                kanjiLabel.setText(FIFTYNINE);
                break;
            case 60:
                kanjiLabel.setText(SIXTY);
                break;
            case 61:
                kanjiLabel.setText(SIXTYONE);
                break;
            case 62:
                kanjiLabel.setText(SIXTYTWO);
                break;
            case 63:
                kanjiLabel.setText(SIXTYTHREE);
                break;
            case 64:
                kanjiLabel.setText(SIXTYFOUR);
                break;
            case 65:
                kanjiLabel.setText(SIXTYFIVE);
                break;
            case 66:
                kanjiLabel.setText(SIXTYSIX);
                break;
            case 67:
                kanjiLabel.setText(SIXTYSEVEN);
                break;
            case 68:
                kanjiLabel.setText(SIXTYEIGHT);
                break;
            case 69: // nice
                kanjiLabel.setText(SIXTYNINE);
                break;
            case 70:
                kanjiLabel.setText(SEVENTY);
                break;
            case 71:
                kanjiLabel.setText(SEVENTYONE);
                break;
            case 72:
                kanjiLabel.setText(SEVENTYTWO);
                break;
            case 73:
                kanjiLabel.setText(SEVENTYTHREE);
                break;
            case 74:
                kanjiLabel.setText(SEVENTYFOUR);
                break;
            case 75:
                kanjiLabel.setText(SEVENTYFIVE);
                break;
            case 76:
                kanjiLabel.setText(SEVENTYSIX);
                break;
            case 77:
                kanjiLabel.setText(SEVENTYSEVEN);
                break;
            case 78:
                kanjiLabel.setText(SEVENTYEIGHT);
                break;
            case 79:
                kanjiLabel.setText(SEVENTYNINE);
                break;
            case 80:
                kanjiLabel.setText(EIGHTY);
                break;
            case 81:
                kanjiLabel.setText(EIGHTYONE);
                break;
            case 82:
                kanjiLabel.setText(EIGHTYTWO);
                break;
            case 83:
                kanjiLabel.setText(EIGHTYTHREE);
                break;
            case 84:
                kanjiLabel.setText(EIGHTYFOUR);
                break;
            case 85:
                kanjiLabel.setText(EIGHTYFIVE);
                break;
            case 86:
                kanjiLabel.setText(EIGHTYSIX);
                break;
            case 87:
                kanjiLabel.setText(EIGHTYSEVEN);
                break;
            case 88:
                kanjiLabel.setText(EIGHTYEIGHT);
                break;
            case 89:
                kanjiLabel.setText(EIGHTYNINE);
                break;
            case 90:
                kanjiLabel.setText(NINETY);
                break;
            case 91:
                kanjiLabel.setText(NINETYONE);
                break;
            case 92:
                kanjiLabel.setText(NINETYTWO);
                break;
            case 93:
                kanjiLabel.setText(NINETYTHREE);
                break;
            case 94: 
                kanjiLabel.setText(NINETYFOUR);
                break;
            case 95:
                kanjiLabel.setText(NINETYFIVE);
                break;
            case 96:
                kanjiLabel.setText(NINETYSIX);
                break;
            case 97:
                kanjiLabel.setText(NINETYSEVEN);
                break;
            case 98:
                kanjiLabel.setText(NINETYEIGHT);
                break;
            case 99:
                kanjiLabel.setText(NINETYNINE);
                break;
            case 100:
                kanjiLabel.setText(ONEHUNDRED);
        }
    }
    
    /**
     * Updates score depending on if the user was correct or incorrect.
     * User gains a point if they are correct and loses a point if they are incorrect.
     * @param isCorrect is user correct?
     */
    public void updateScore(boolean isCorrect)
    {
        if(isCorrect)
        {
            score++; // gain a point
            scoreLabel.setText(Integer.toString(score));
        }
        else
        {
            score--; // lose a point
            scoreLabel.setText(Integer.toString(score));
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

        jLabel1 = new javax.swing.JLabel();
        kanjiLabel = new javax.swing.JLabel();
        answerTextField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        feedbackLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        levelComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setMinimumSize(new java.awt.Dimension(700, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("What number is this?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 30, 438, 86);

        kanjiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(kanjiLabel);
        kanjiLabel.setBounds(0, 90, 700, 314);

        answerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(answerTextField);
        answerTextField.setBounds(190, 430, 120, 40);

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton);
        nextButton.setBounds(350, 440, 57, 25);

        feedbackLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        feedbackLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(feedbackLabel);
        feedbackLabel.setBounds(10, 490, 440, 60);

        jLabel2.setText("Score");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 410, 33, 16);

        scoreLabel.setText("0");
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(460, 440, 40, 16);

        jLabel3.setText("Level");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(530, 410, 29, 16);

        levelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        levelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(levelComboBox);
        levelComboBox.setBounds(520, 440, 50, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setAnswer();
        // show dialog box explaining the game when the window is opened
        // using HTML tags to make font larger
        String welcomeMessage = "<html><h2>Welcome to flashcards!\n"
                + "<html><p style='font-size:15px'>Select a level, and translate "
                + "the Kanji number to English. \n"
                + "<html><p style='font-size:15px'>Get it right, you get a point. "
                + "Get it wrong you lose a point. \n"
                + "<html><p style='font-size:15px'>Good luck!";
        String title = "Flashcards";
        JOptionPane.showMessageDialog(null, welcomeMessage, title, JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_formWindowOpened

    private void answerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerTextFieldActionPerformed
       // check if users answer is correct
        guess = Integer.parseInt(answerTextField.getText());
        if(guess == answer)
        {
            feedbackLabel.setText("Correct!");
            feedbackLabel.setForeground(Color.GREEN);
            nextButton.setVisible(true); // show next button
            updateScore(true); // increase score by 1
            answerTextField.setEnabled(false); // disable the text field (no cheating)
        }
        else
        {
            feedbackLabel.setText("Incorrect, try again.");
            feedbackLabel.setForeground(Color.RED);
            answerTextField.setText(""); // clear text field
            updateScore(false); // decrease score by 1
        }
    }//GEN-LAST:event_answerTextFieldActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // reset page when user clicks next button
        setAnswer(); // reset answer
        nextButton.setVisible(false); // hide button
        answerTextField.setText(""); // clear answer field
        answerTextField.setEnabled(true);
        answerTextField.requestFocus();
        feedbackLabel.setText(""); // clear feedback
    }//GEN-LAST:event_nextButtonActionPerformed

    private void levelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelComboBoxActionPerformed
        // reset answer when level is changed
        setLevel();
        setAnswer();
    }//GEN-LAST:event_levelComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(Flashcards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flashcards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flashcards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flashcards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flashcards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerTextField;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel kanjiLabel;
    private javax.swing.JComboBox<String> levelComboBox;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}

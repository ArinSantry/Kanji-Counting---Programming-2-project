/*
 * Number.java, KanjiCounting, Team Millennium
 * Helper class for CountingGame.java.
 * Sets Unicode characters and spelling for Kanji numbers and their English equivalents.
 */
package KanjiCounting;

/**
 *
 * @author hdren
 */
public class Number {
    
    // these are the numbers represented in kanji form 
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
    private final String HUNDRED = "" + '\u767E';
    
    private final String ZEROW = "rei";
    private final String ONEW = "ichi";
    private final String TWOW = "ni";
    private final String THREEW = "san";
    private final String FOURW = "shi";
    private final String FIVEW = "go";
    private final String SIXW = "rok";
    private final String SEVENW = "nana";
    private final String EIGHTW = "achi";
    private final String NINEW = "kyuu";
    private final String TENW = "juu";
    private final String HUNDREDW = "hyaku";
    
    private int numberA;
    private String numberK;
    private String kanjiWord;

    /**
     * This is the constructor for the number class.
     * @param number 
     */
    public Number(int number) {
        setNumberA(number);
        setNumberK(number);
        setKanjiWord();
    }
    
    /**
     * This was needed to satisfy the compiler. It functions the same as the constructor.
     * @param number 
     */
    public void Number(int number) {
        setNumberA(number);
        setNumberK(number);
        setKanjiWord();
    }

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public String getNumberK() {
        return numberK;
    }

    public void setNumberK(int number) {
        String numberK = "";
        if (number == 100) numberK = HUNDRED;
        else if(100 > number && number > 10){
            switch (number / 10) {
                case 1: numberK = TEN; break;
                case 2: numberK = TWO + TEN; break;
                case 3: numberK = THREE + TEN; break;
                case 4: numberK = FOUR + TEN; break;
                case 5: numberK = FIVE + TEN; break;
                case 6: numberK = SIX + TEN; break;
                case 7: numberK = SEVEN + TEN; break;
                case 8: numberK = EIGHT + TEN; break;
                case 9: numberK = NINE + TEN; break;
            }
            switch (number % 10) {
                case 0: break;
                case 1: numberK += ONE; break;
                case 2: numberK += TWO; break;
                case 3: numberK += THREE; break;
                case 4: numberK += FOUR; break;
                case 5: numberK += FIVE; break;
                case 6: numberK += SIX; break;
                case 7: numberK += SEVEN; break;
                case 8: numberK += EIGHT; break;
                case 9: numberK += NINE; break;
            }
        }
        else {
            switch (number) {
                case 0: numberK = ZERO; break;
                case 1: numberK = ONE; break;
                case 2: numberK = TWO; break;
                case 3: numberK = THREE; break;
                case 4: numberK = FOUR; break;
                case 5: numberK = FIVE; break;
                case 6: numberK = SIX; break;
                case 7: numberK = SEVEN; break;
                case 8: numberK = EIGHT; break;
                case 9: numberK = NINE; break;
                case 10: numberK = TEN; break;
            }
        }
        this.numberK = numberK;
    }

    public String getKanjiWord() {
        return kanjiWord;
    }

    public void setKanjiWord() {
        if (numberA == 100) kanjiWord = HUNDREDW; // this sets the word for 100
        // this else block will set the word for the range from 10 to 100 noninclusive
        else if(100 > numberA && numberA > 10){
            switch (numberA / 10) {
                case 1: kanjiWord = TENW; break;
                case 2: kanjiWord = TWOW; break;
                case 3: kanjiWord = THREEW; break;
                case 4: kanjiWord = FOURW; break;
                case 5: kanjiWord = FIVEW; break;
                case 6: kanjiWord = SIXW; break;
                case 7: kanjiWord = SEVENW; break;
                case 8: kanjiWord = EIGHTW; break;
                case 9: kanjiWord = NINEW; break;
            }
            if (kanjiWord != TENW) kanjiWord += " " + TENW + " "; // this is used to space out the words and add in the symbol for 10
            else if (kanjiWord == TENW) kanjiWord += " "; // if the number is in the 10s then this will add the space for the kanji word
            switch (numberA % 10) {
                case 0: break;
                case 1: kanjiWord += ONEW; break;
                case 2: kanjiWord += TWOW; break;
                case 3: kanjiWord += THREEW; break;
                case 4: kanjiWord += FOURW; break;
                case 5: kanjiWord += FIVEW; break;
                case 6: kanjiWord += SIXW; break;
                case 7: kanjiWord += SEVENW; break;
                case 8: kanjiWord += EIGHTW; break;
                case 9: kanjiWord += NINEW; break;
            }
        }
        // this else block will set the word for the range from 0 to 10 inclusive
        else {
            switch (numberA) {
                case 0: kanjiWord = ZEROW; break;
                case 1: kanjiWord = ONEW; break;
                case 2: kanjiWord = TWOW; break;
                case 3: kanjiWord = THREEW; break;
                case 4: kanjiWord = FOURW; break;
                case 5: kanjiWord = FIVEW; break;
                case 6: kanjiWord = SIXW; break;
                case 7: kanjiWord = SEVENW; break;
                case 8: kanjiWord = EIGHTW; break;
                case 9: kanjiWord = NINEW; break;
                case 10: kanjiWord = TENW; break;
            }
        }
    }
    
    
    
    
    
    
}

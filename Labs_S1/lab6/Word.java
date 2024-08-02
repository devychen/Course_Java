/**
 * @author mkz
 *
 * A class to store words, with methods to get
 *  the word, the stem of the word, and the number
 *  of syllables in the word.
 */

public class Word {

    private String word;
    private String stem;
    private int syllableCnt;

    /**
     * Default constructor that initialises the instance with an empty word
     * Instance variables initialised to default values
     */
    public Word(){
        word = "";
        stem = "";
        syllableCnt = 0;
    }

    /**
     * A constructor that initialises the instance with String `aWord`.
     * @param aWord
     */
    public Word(String aWord){
        setWord(aWord);
    }


    /**
     * Update the value of Word, set `word` to `String newWord`
     * @param newWord - The new value of Word
     */
    public void setWord(String newWord)
    {
        word = newWord;
        stem = createStem(newWord);
        syllableCnt = createSyllableCnt(newWord);
    }

    /**
     *
     * @return the word
     */
    public String getWord(){
        return word;
    }
   
    /**
     * Get the stem of Word
     * @return The stem of Word
     */
    public String getStem()
    {
        return stem;
    }

    /**
     *
     * @return the number of syllables in this `Word`
     */
    public int getSyllableCnt(){
        return syllableCnt;
    }

    /**
     * Computes the number of syllables in this Word and
     * return the number to the caller.
     * @param aWord
     * @return the number to the caller
     */
    private int createSyllableCnt(String aWord){
        boolean lastWasVowel = false;
        boolean thisIsVowel = false;
        int sc = 0;

        // empty word has no syllables
        if (aWord.length() == 0) {
            return 0;
        }

        for (int i = 0; i < aWord.length(); i++) {
            // Determine if this char is a vowel
            switch (aWord.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    thisIsVowel = true;
                    break;
                default:
                    thisIsVowel = false;
            }

            // only increment syllableCnt if
            // previous char was NOT a vowel
            if (thisIsVowel && !lastWasVowel) {
                sc++;
            }

            // update lastWasVowel for the next iteration
            lastWasVowel = thisIsVowel;
        }

        // a trailing 'e' would have been counted as a
        // syllable when it shouldn't have been
        if (aWord.endsWith("e")) {
            sc--;
        }

        // all words have at least 1 syllable
        if (sc <= 0) {
            sc = 1;
        }

        return sc;

    }

    /**
     * Creates the stem for this `Word` and
     * returns a String with the stem.
     * @param aWord
     * @return a String with the stem
     */
    private String createStem(String aWord){
        String theStem;
        int len = aWord.length();

        if (aWord.endsWith("ing") && len>4) {
            theStem = aWord.substring(0,len-3);
        }

        else if (aWord.endsWith("sses")) {
            theStem = aWord.substring(0,len-2);
        }

        else if (aWord.endsWith("ies")) {
            theStem = aWord.substring(0,len-3)+"y";
        }

        else if (aWord.endsWith("ss")) {
            theStem = aWord;
        }

        else if (aWord.endsWith("s")) {
            theStem = aWord.substring(0,len-1);
        }

        else if (aWord.endsWith("eed") && len > 4) {
            theStem = aWord.substring(0,len-1);
        }

        else if (aWord.endsWith("ed") && len > 4) {
            theStem = aWord.substring(0,len-2);
        }

        else {
            theStem = aWord;
        }

        return theStem;

    }

}

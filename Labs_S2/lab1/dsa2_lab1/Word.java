package dsa2_lab1;

/**
 * @author mkz
 * TASK: Complete the class based on html file.
 *      First this class then `SentenceBuilder`.
 */

public class Word {

    // instance variables
    private String word;
    private String tag;

    // constructors

    /**
     * Default constructor
     */
    public Word(){
        word = "";
        tag = "";
    }

    /**
     * Construct a Word object with just a form
     * @param aForm
     */
    public Word(String aForm){
        word = aForm;
    }

    /**
     * Construct a Word with form and tag values
     * @param aForm
     * @param aPOSTag
     */
    public Word(String aForm, String aPOSTag){
        word = aForm;
        tag = aPOSTag;
    }


    /**
     * Get the word form.
     * @return
     */
    public String getForm(){
        return word;
    }

    /**
     * Get the tag
     * @return
     */
    public String getTag(){
        return tag;
    }


    // helper methods

    /**
     * Two Words are equal if
     *      the forms and pos tag values are equal,
     *      ignoring case
     * @param otherObj
     * @return true if two words are equal
     */
    public boolean equals(Object otherObj){
        if (this.getForm().equalsIgnoreCase(((Word)otherObj).getForm()) &&
                this.getTag().equalsIgnoreCase(((Word)otherObj).getTag())){
            return true;
        }
        return false;
    }

    /**
     * Generate a String representation of the Word
     * @return
     */
    public String toString(){
        String res = "Word: " + word + "\n" +
                "Tag: " + tag + "\n";
        return res;
    }
}
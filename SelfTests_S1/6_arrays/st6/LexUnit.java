package st6;

/**
 * @author mkz
 * TASK: Define a class to represent a lexical unit
 *      with a wordForm & synonyms,
 *      described by UML diagram.
 *
 * WHY THIS: 实例变量可以是任何类型的数据，包括数组
 *  (to show `how an array can be used as an instance variable`)
 */

public class LexUnit {

    private String wordForm;
    private String[] synonyms;
    private int numSynonyms;
    private int INITIAL_SIZE = 3;

    /**
     * Default constructor
     *      to initialize the instance variables
     *      so that the LexUnit has no wordForm and no synonyms
     */
    public LexUnit(){
        wordForm = "";
        synonyms = new String[3];
        numSynonyms = 0;
    }

    /**
     * Constructor
     *      to initialize the instance variables
     *      so that the LexUnit has the given wordForm but no synonyms
     */
    public LexUnit(String wordForm){
//        this.wordForm = wordForm;
        this();
        setWordForm(wordForm);
    }

    /**
     * Return the wordForm for this LexUnit
     * @return
     */
    public String getWordForm(){
        return this.wordForm;
    }

    /**
     * Set the wordForm for this LexUnit
     * @param wordForm
     */
    public void setWordForm(String wordForm){
        this.wordForm = wordForm;
    }

    /**
     * Return the synonyms for this LexUnit; 
     *  it should return a copy of the used portion of the synonym array
     * @return
     */
    public String[] getSynonyms(){
        String[] rval = new String[numSynonyms];
        
        for(int i = 0; i < synonyms.length; i++){
            rval[i] = synonyms[i];
        }
        return rval;
    }

    /**
     * Return the number of synonyms for this LexUnit
     * @return
     */
    public int getNumSynonyms(){
        return this.numSynonyms;
    }

    /**
     * Add aSynonym to this LexUnit's synonyms;
     *      if the array is not big enough to hold another element,
     *      resize the array before adding
     * @param aSynonym
     */
    public void addSynonym(String aSynonym){
        // check capacity
        if(numSynonyms >= synonyms.length){
            // enlarge and copy
            String[] tmp = new String[numSynonyms + INITIAL_SIZE];
            for(int i = 0; i < synonyms.length; i++){
                tmp[i] = synonyms[i];
            }
            // update
            synonyms = tmp;
        }
        // add new
        // why 在if之外：确保无论数组是否需要扩展，都要添加新元素并更新计数
        synonyms[numSynonyms] = aSynonym;
        numSynonyms++;
    }

    /**
     * Generate and return a String containing the word form,
     *      the number of synonyms, and the synonyms
     * @return
     */
    public String toString(){

        String rval = wordForm + " :";
        for(int i = 0; i < numSynonyms; i++){
            rval += " " + synonyms[i];
        }

        return rval;
    }
}

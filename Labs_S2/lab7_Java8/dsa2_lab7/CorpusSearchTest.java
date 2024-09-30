package dsa2_lab7;

/**
 * @author mkz
 * TASK: 
 * Add a JUnit test class and assess the search method with at least the following searches:
 * Search number of all words representing word form "in"
 * Search number of all words representing POS tag "APPR" and form "für"
 * Search number of all words where the POS tag begins with "VV"
 * Search number of all words where the POS tag is "APPR" and the form is either "für" or "in"
 */

import org.junit.Test;

import java.beans.Transient;
import java.io.FileNotFoundException;
import java.util.function.Predicate;
import static org.junit.Assert.*;

public class CorpusSearchTest {
    
    CorpusSearch corpusSearch;

    // constructor
    public CorpusSearchTest() throws FileNotFoundException{
        corpusSearch = new CorpusSearch("tuebadz_1-50-utf8.export");
    } 

    @Test
    public void test_in(){
        Predicate<Word> needle = word -> word.getForm().equals("in");
        // Predicate<Word> needle = new Predicate<Word>() {
        //     @Override
        //     public boolean test(Word word){
        //         return word.getForm().equals("in");
        //     }  
        // };
        assertEquals(2, corpusSearch.search(needle).size());
    }

    @Test
    public void test_apprnfur(){
        Predicate<Word> needle = word -> word.getTag().equals("APPR") &&
                                        word.getForm().equals("für");
        assertEquals(1, corpusSearch.search(needle).size());
        /*
        Predicate<Word> needle = new Predicate<Word>(){
            @Override
            public boolean test(Word word){
                return word.getTag().equals("APPR") &&
                        word.getForm().equals("für")   
            }
        };

         */
    }

    @Test
    public void test_vv(){
        Predicate<Word> needle = word -> word.getTag().startsWith("VV");
        assertEquals(3, corpusSearch.search(needle).size());
    }

    @Test
    public void test_apprnfuroin(){
        Predicate<Word> needle = word -> word.getTag().equals("APPR") &&
                                        word.getForm().equals("für") ||
                                        word.getForm().equals("in");
        assertEquals(3, corpusSearch.search(needle).size());
    }


}

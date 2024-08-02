import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.Test;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called
 * when running the test with JUnit.
 */
public class WordTest {
    static Word word1;
    static Word word2;
    static Word word3;
    static Word word4;
    static Word word5;
    static Word word6;
    
    // setup test environment
    @BeforeClass
    public static void setUp() {
        
        // a simple, innocent word.
        word1 = new Word();
        word1.setWord("ponies");
        
        /* create a word with the default constructor,
        then initialize the instance with setWord() */
        word2 = new Word();
        word2.setWord("motoring");
        
        // default constructor, not initialized        
        word3 = new Word();
        
        word4 = new Word();
        word4.setWord("I");
        
        word5 = new Word();
        word5.setWord("owl");
        
        word6 = new Word();
        word6.setWord("eagle");
    }
    
    // throw away all the words...
    @AfterClass
    public static void tearDown() {          
        word1 = null;
        word2 = null;
        word3 = null;
    }
    
    /**
     * test getWord() method
     */
    @Test
    public void testGetWord() {
        assertNotNull("word1 not null",word1);
        assertEquals("ponies",word1.getWord());
        assertEquals("GetWord word2","motoring",word2.getWord());
        assertEquals("",word3.getWord());
    }

    /**
     * test getStem() method
     */
    @Test
    public void testGetStem() {
        assertEquals("pony",word1.getStem());
        assertEquals("motor",word2.getStem());
        assertEquals("",word3.getStem());
    }

    /**
     * test getSyllableCnt() method
     */
    @Test
    public void testGetSyllableCnt() {
        assertEquals(2,word1.getSyllableCnt());
        assertEquals(3,word2.getSyllableCnt());
        assertEquals(0,word3.getSyllableCnt());
        assertEquals(1,word4.getSyllableCnt());
        assertEquals(1,word5.getSyllableCnt());
        assertEquals(1,word6.getSyllableCnt());
    }
}

package dsa2_lab1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SentenceBuilderTest {

    @Test
    public void testNumberOfSentences() {
        try {
            SentenceBuilder testBuilder = new SentenceBuilder("tuebadz_1-50-utf8.export");
            int count = 0;
            while (testBuilder.hasNext()) {
                testBuilder.next();
                count++;
                //System.out.println(count);
            }
            System.out.println(count);
            assertEquals(50, count);

        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testWordsInSentence() {
        try {
            SentenceBuilder testBuilder = new SentenceBuilder("tuebadz_1-50-utf8.export");
            Word die = new Word("die", "ART");
            ArrayList<Word> list = testBuilder.next();
            System.out.println(list.get(1).toString());
            assertEquals(list.get(1), die);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testWordsInSentence2() {
        try {
            SentenceBuilder testBuilder = new SentenceBuilder("tuebadz_1-50-utf8.export");
            Word pr = new Word("Flossen", "VVFIN");
            testBuilder.next();
            ArrayList<Word> list = testBuilder.next();
            System.out.println(list.get(5).toString());
            assertEquals(17, list.size());
            assertEquals(list.get(5), pr);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

}

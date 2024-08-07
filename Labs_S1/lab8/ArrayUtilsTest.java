/**
 * @author: mkz
 * Task: Test the ArrayUtils class.
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ArrayUtilsTest {

    /**
     * Test reverseArray() 
     */
    @Test
    public void testReverseArray1() {
        String[] a1 = {"AA", "BB", "CC", "DD", "EE"};
        String[] expected = {"EE", "DD", "CC", "BB", "AA"};
        Object[] res = ArrayUtils.reverseArray(a1);
        assertTrue(expected.length == res.length);

        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i],expected[i]);
        }
    }

    /* TODO: More tests after this comment.... */

    /**
     * Test null
     */
    @Test
    public void testReverseArray2() {}

    @Test
    public void testConcatArray1() {}

    /**
     * Test null
     */
    @Test
    public void testConcatArray2() {}


    @Test
    public void searchArrayForAnObject1(){}

    /**
     * Test null
     */
    @Test
    public void searchArrayForAnObject2(){}
}
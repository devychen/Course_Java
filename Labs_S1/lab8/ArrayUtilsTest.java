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
     * Test reverseArray(), valid
     */
    @Test
    public void testReverseArray() {
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
     * Test reverseArray(), array null
     */
    @Test
    public void testReverseArray1() {
        String[] a1 = null;
        String[] expected = null;
        Object[] res = ArrayUtils.reverseArray(a1);

        assertTrue(expected.length == res.length);

        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i],expected[i]);
        }

    }

    /**
     * Test concatArray(), both arrays null
     */
    @Test
    public void testConcatArray1() {
        String[] a1 = null;
        String[] a2 = null;
        String[] expected = null;                                       // expected result
        Object[] res = ArrayUtils.concatArrays(a1, a2);   // actual result

        assertTrue(expected.length == res.length);

        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i],expected[i]);
        }
    }

    /**
     * Test concatArray(), array1 null
     */
    @Test
    public void testConcatArray2() {
        String[] a1 = null;
        String[] a2 = {"AA", "BB", "CC"};
        String[] expected = {"AA", "BB", "CC"};
        Object[] res = ArrayUtils.concatArrays(a1, a2);
        assertTrue(expected.length == res.length);
        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i],expected[i]);
        }
    }

    /**
     * Test concatArray(), array2 null
     */
    @Test
    public void testConcatArray3() {
        String[] a1 = {"AA", "BB", "CC"};
        String[] a2 = null;
        String[] expected = {"AA", "BB", "CC"};
        Object[] res = ArrayUtils.concatArrays(a1, a2);
        assertTrue(expected.length == res.length);
        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i],expected[i]);
        }

    }

    /**
     * Test concatArray(), valid
     */
    @Test
    public void testConcatArray() {
        String[] a1 = {"AA", "BB", "CC"};
        String[] a2 = {"DD", "EE"};
        String[] expected = {"AA", "BB", "CC", "DD", "EE"};
        Object[] res = ArrayUtils.concatArrays(a1, a2);
        assertTrue(expected.length == res.length);
        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i],expected[i]);
        }
    }


    /**
     * Test searchArrayForAnObject(), array null
     */
    @Test
    public void searchArrayForAnObject1(){
        String[] a1 = null;
        int expected = -1;
        int res = ArrayUtils.searchArrayForAnObject(a1, "DD");
        assertEquals(expected,res);
    }

    /**
     * Test searchArrayForAnObject(), object not found
     */
    @Test
    public void searchArrayForAnObject2(){
        String[] a1 = {"AA", "BB", "CC"};
        int expected = -1;
        int res = ArrayUtils.searchArrayForAnObject(a1, "DD");
        assertEquals(expected,res);
    }

    /**
     * Test searchArrayForAnObject(), valid
     */
    @Test
    public void searchArrayForAnObject(){
        String[] a1 = {"AA", "BB", "CC", "DD", "EE"};
        int expected = 3;
        int res = ArrayUtils.searchArrayForAnObject(a1, "DD");
        assertEquals(expected, res);
    }
}
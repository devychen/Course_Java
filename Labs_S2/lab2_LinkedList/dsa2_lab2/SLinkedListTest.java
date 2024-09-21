package dsa2_lab2;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.*;

/**
 * this test case was provided by master Kuan, later modified by his disciple Aria.
 */

public class SLinkedListTest {

    private SLinkedList<String> sl;

    //@Before
    public void setUp() {
        sl = new SLinkedList<>();
    }

    //@After
    public void tearDown() {
        sl = null;
    }

    /**
     * @Test add - exception
     */
    @Test
    public void testAdd_1() {
        setUp();
        try {
            sl.add(null);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void testAdd_2() {
        setUp();
        assertNotNull("testAdd_2", 1);
        sl.add("Hallo");
        sl.add("Welt");
        assertTrue("testAdd2", sl.size() == 2);
        sl.add("!");
        assertTrue("testAdd2", sl.size() == 3);
    }

    /**
     * @Test size
     */
    @Test
    public void testSize() {
        setUp();
        assertEquals(0, sl.size());
        sl.add("A");
        sl.add("S");
        sl.add("V");
        assertEquals(3, sl.size());
    }

    /**
     * @Test toString
     */
    @Test
    public void testToString() {
        setUp();
        assertNotNull("testToString", 1);
        sl.add("A");
        sl.add("S");
        sl.add("V");
        assertEquals("[A,S,V]", sl.toString());
    }

    /**
     * @Test get - exception
     */
    @Test
    public void testGet_1() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        try {
            sl.get(3);
        } catch (Exception e) {
        }
    }

    /**
     * @Test get
     */
    @Test
    public void testGet_2() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        assertEquals("S", sl.get(1));
    }

    /**
     * @Test indexOf - exception
     */
    @Test
    public void testIndexOf_1() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        try {
            sl.indexOf(null);
        } catch (Exception e) {
        }
    }

    /**
     * @Test indexOf - exception
     */
    @Test
    public void testIndexOf_2() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        assertEquals(-1, sl.indexOf("N"));
    }

    /**
     * @Test indexOf
     */
    @Test
    public void testIndexOf_3() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        assertEquals(1, sl.indexOf("S"));
    }

    @Test
    public void testIndexOf_4() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        sl.add("w");
        sl.add("q");
        sl.add("t");
        assertEquals(1, sl.indexOf("S"));
        assertEquals(4, sl.indexOf("q"));
        assertEquals(1, sl.indexOf("S"));

    }

    /**
     * @Test isEmpty - true and false
     */
    @Test
    public void testIsEmpty() {
        setUp();
        assertTrue(sl.isEmpty());
        sl.add("etwas");
        assertFalse(sl.isEmpty());
        sl.remove(0);
        assertTrue(sl.isEmpty());
    }

    /**
     * @Test remove - exception
     */
    @Test
    public void testRemove_1() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        try {
            sl.remove(3);
        } catch (Exception e) {
        }
    }

    /**
     * @Test remove
     */
    @Test
    public void testRemove_2() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        sl.add("N");
        assertEquals("N", sl.remove(3));
        assertEquals("S", sl.remove(1));
        assertEquals("A", sl.remove(0));
        assertEquals("V", sl.remove(0));
        assertTrue(sl.isEmpty());
    }
}

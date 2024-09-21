package dsa2_lab2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;


public class LinkedListIteratorTest {
    private SLinkedList<String> sl;

    //@Before
    public void setUp() {
        sl = new SLinkedList<>();
    }

    //@After
    public void tearDown() {
        sl = null;
    }

    @Test
    public void testIterator() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        sl.add("N");
        Iterator<String> it = sl.iterator();
        int count = 0;
        while (it.hasNext()) {
            count++;
            it.next();
        }
        assertEquals(count, 4);
    }

    @Test
    public void testIterator2() {
        setUp();
        sl.add("A");
        sl.add("S");
        sl.add("V");
        sl.add("N");
        Iterator it = sl.iterator();
        it.next();
        assertEquals(it.next(), "S");
        assertEquals(it.next(), "V");
    }
}

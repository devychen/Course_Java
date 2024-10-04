import junit.framework.TestCase;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BinaryTreeTest extends TestCase {
    private BinaryTree<String> root;
    
    protected void setUp()  {
        BinaryTree<String> d = new BinaryTree<String>("D");
        BinaryTree<String> e = new BinaryTree<String>("E");
        BinaryTree<String> b = new BinaryTree<String>
                ("B",d,e);
        BinaryTree<String> c = new BinaryTree<String>("C");
        BinaryTree<String> a = new BinaryTree<String>
                ("A",b,c);
        
        root = a;
    }
    
    /**
     *
    public void testToString() {        
        assertEquals("toString",root.toString(),"(A (B D E) C)");  
    }
    */
    
    /**
     *
     */
    public void testContains1()  {
        assertTrue("contains1",root.contains("C"));
    }
    
    public void testContains1a()  {
        assertTrue("contains1",root.contains("C"));
    }
    
    /**
     *
     */
    public void testContains2()  {
        assertFalse("contains2",root.contains("Bla"));
    }
    
    /**
     *
     */
    public void testFind1()  {
        String l = "";
        try  {
            l = root.find("A");
            assertEquals("find1",l,"A");
        }
        catch (NoSuchElementException e)  {
            fail("\"A\" is in tree");            
        }
    }
    
    /**
     *
     */
    public void testFind2()  {
        String l = "";
        try  {
            l = root.find("Boo");
            fail("\"Boo\" is not in tree"); 
        }
        catch (NoSuchElementException e)  {
             //Success
        }
    }
    
    /**
     *
     */
    public void testIteratorPreOrder()  {
        Iterator<String> it = root.iteratorPreOrder();
        assertTrue(it.hasNext());
        assertEquals(it.next(),"A");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"B");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"D");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"E");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"C");
        assertFalse(it.hasNext());
    }
    
    /**
     *
     */
    public void testIteratorInOrder()  {
        Iterator it = root.iteratorInOrder();
        assertTrue(it.hasNext());
        assertEquals(it.next(),"D");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"B");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"E");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"A");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"C");
        assertFalse(it.hasNext());
    }
    
    /**
     *
     */
    public void testIteratorPostOrder()  {
        Iterator it = root.iteratorPostOrder();
        assertTrue(it.hasNext());
        assertEquals(it.next(),"D");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"E");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"B");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"C");
        assertTrue(it.hasNext());
        assertEquals(it.next(),"A");
        assertFalse(it.hasNext());
    }   
}



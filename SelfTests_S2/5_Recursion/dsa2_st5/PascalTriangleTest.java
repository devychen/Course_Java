package dsa2_st5;
import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 * @author mkz
 * Description: A JUnit test for handshake and pascal.
 */

public class PascalTriangleTest extends TestCase {

    /**
     * Test handshake.
     */
    public void testHandShakes() {
        try {
            PascalTriangle.handshake(-1);
            fail();
        } catch (Exception e) {
            // good
        }
        assertEquals(0,PascalTriangle.handshake(0));
        assertEquals(0,PascalTriangle.handshake(1));
        assertEquals(1,PascalTriangle.handshake(2));
        assertEquals(3,PascalTriangle.handshake(3));
        assertEquals(6,PascalTriangle.handshake(4));
        assertEquals(10,PascalTriangle.handshake(5));

    }


    /**
     * Test pascal.
     */
    public void testPascal(){
        try{
            PascalTriangle.pascal(-1);
            fail();
        } catch (Exception e) {
            // good
        }

        int[] result;
        int[][] expected = {
                {1},
                {1,1},
                {1,2,1},
                {1,3,3,1},
                {1,4,6,4,1},
                {1,5,10,10,5,1},
                {1,6,15,20,15,6,1}
        };

        for (int row = 0; row < expected.length; row++) {
            result = PascalTriangle.pascal(row);

            for(int i = 0; i < expected[row].length; i++){
                assertEquals("row: " + row + "element: " + i,
                        expected[row][i],result[i]);
            }
        }
    }

}
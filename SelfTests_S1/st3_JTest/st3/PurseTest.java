package st3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A JUnit test case class for the Purse class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class PurseTest
{    
    public static final double EPSILON = 0.01;
    
    /**
     * Test the AddOneCentCoins method.
     */
    @Test
    public void testAddOneCentCoins()
    {
        Purse myPurse = new Purse();
        assertEquals(0, myPurse.getTotal(), EPSILON); 
        
        myPurse.addOneCentCoins(1);
        assertEquals(0.01, myPurse.getTotal(), EPSILON); 
        
        myPurse.addOneCentCoins(100);
        assertEquals(1.01, myPurse.getTotal(), EPSILON); 
    }
    
    /**
     * Test the AddTenCentCoins method.
     */
    @Test
    public void testAddTenCentCoins()
    {
        Purse myPurse = new Purse();
        
        myPurse.addTenCentCoins(1);
        assertEquals(0.10, myPurse.getTotal(), EPSILON); 
        
        myPurse.addTenCentCoins(100);
        assertEquals(10.10, myPurse.getTotal(), EPSILON); 
    }
    
    /**
     * Test the AddFiftyCentCoins method.
     */
    @Test
    public void testAddFiftyCentCoins()
    {
        Purse myPurse = new Purse();
        
        myPurse.addFiftyCentCoins(1);
        assertEquals(0.50, myPurse.getTotal(), EPSILON); 
        
        myPurse.addFiftyCentCoins(100);
        assertEquals(50.50, myPurse.getTotal(), EPSILON); 
    }
    
    /**
     * Test the AddOneEuroCoins method.
     */
    @Test
    public void testAddOneEuroCoins()
    {
        Purse myPurse = new Purse();
        
        myPurse.addOneEuroCoins(1);
        assertEquals(1.00, myPurse.getTotal(), EPSILON); 
        
        myPurse.addOneEuroCoins(100);
        assertEquals(101.00, myPurse.getTotal(), EPSILON); 
    }

    /**
     * Test the remove method.
     */
    @Test
    public void testRemoveOneEuro(){
        Purse myPurse = new Purse();

        myPurse.addOneEuroCoins(100);
        myPurse.remove(1.0, 50);
        assertEquals(50.00, myPurse.getTotal(), EPSILON);
    }

    @Test
    public void testRemoveFiftyCent(){
        Purse myPurse = new Purse();

        myPurse.addFiftyCentCoins(100);
        myPurse.remove(.50, 50);
        assertEquals(25.00, myPurse.getTotal(), EPSILON);
    }

    @Test
    public void testRemoveTenCent(){
        Purse myPurse = new Purse();

        myPurse.addTenCentCoins(100);
        myPurse.remove(.10, 50);
        assertEquals(5.00, myPurse.getTotal(), EPSILON);
    }

    @Test
    public void testRemoveOneCent(){
        Purse myPurse = new Purse();

        myPurse.addOneCentCoins(100);
        myPurse.remove(.01, 50);
        assertEquals(.50, myPurse.getTotal(), EPSILON);
    }

}

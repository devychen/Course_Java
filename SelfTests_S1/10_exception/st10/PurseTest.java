package st10;

import junit.framework.TestCase;

/**
 * A JUnit test case class for the Purse class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 *
 * @author mkz
 * TASK: complete the test based on new methods in Purse class.
 */
public class PurseTest extends TestCase
{
    public static final double EPSILON = 0.01;
    
    /**
     * Test the AddCoins method.
     */
    public void testAddCoins()
    {
        Purse myPurse = new Purse();
        assertEquals(0, myPurse.getTotal(), EPSILON); 

        try
        {
            myPurse.addCoins(Coin.ONE_CENT, 1);
            assertEquals(0.01, myPurse.getTotal(), EPSILON); 
            
            myPurse.addCoins(Coin.ONE_CENT, 100);
            assertEquals(1.01, myPurse.getTotal(), EPSILON); 
        }
        catch (PurseException e)
        {
            fail("Exception should not be thrown");
        }
    }
    
    /**
     * Test the AddCoins method - negative argument.
     */
    public void testAddCoinsNeg()
    {
        Purse myPurse = new Purse();
        
        try
        {
            myPurse.addCoins(Coin.TEN_CENT, -1);
            fail("Exception should have been thrown");
        }
        catch (PurseException e)
        {
            // good, this is what we want
        }
    }

    /**
     * Test removeCoins - standard
     */
    public void testRemoveCoins(){
        Purse myPurse = new Purse();
        try{
            myPurse.addCoins(Coin.ONE_CENT, 1);
            myPurse.addCoins(Coin.TEN_CENT, 2);
            myPurse.addCoins(Coin.FIFTY_CENT, 3);
            myPurse.addCoins(Coin.ONE_EURO, 4);
            myPurse.removeCoins(Coin.ONE_CENT, 1);
            myPurse.removeCoins(Coin.TEN_CENT, 1);
            myPurse.removeCoins(Coin.FIFTY_CENT, 2);
            myPurse.removeCoins(Coin.ONE_EURO, 4);
        } catch (PurseException e) {
            fail("Exception should not have been thrown");
        }
    }

    /**
     * Test removeCoins - negative argument
     */
    public void testRemoveCoinsNeg(){
        Purse myPurse = new Purse();
        try{
            myPurse.addCoins(Coin.TEN_CENT, -1);
            fail("Exception should have been thrown");
        } catch (PurseException e){
            // good
        }
    }

    /**
     * Test removeCoins - not enough in purse
     */
    public void testRemoveCoinsTooFew(){
        Purse myPurse = new Purse();
        try{
            myPurse.addCoins(Coin.ONE_CENT, 1);
            myPurse.removeCoins(Coin.ONE_CENT, 2);
            fail("Exception should have been thrown");
        } catch (PurseException e){
            // good
        }
        try {
            myPurse.addCoins(Coin.TEN_CENT, 2);
            myPurse.removeCoins(Coin.TEN_CENT, 3);
            fail("Exception should be thrown");
        } catch (PurseException e){
            // good
        }
    }
}

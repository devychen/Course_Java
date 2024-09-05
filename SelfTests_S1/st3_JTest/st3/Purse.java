package st3;
/**
 *
 * @author: mkz
 * Description: A class to simulate a coin purse that can hold
 *              1-cent, 10-cent, 50-cent, and 1-euro coins
 *
 * Task: Replace the method body stubs with appropriate code.
 *      Compile and test often, until all tests pass.
 */

public class Purse 
{
    // Coin value constants
    public static final double ONE_EURO_VALUE = 1.0;
    public static final double FIFTY_CENT_VALUE = .50;
    public static final double TEN_CENT_VALUE = .10;
    public static final double ONE_CENT_VALUE = .01;

    // Instance variables for number of each coin denomination
    private int numOneEuro;
    private int numFiftyCent;
    private int numTenCent;
    private int numOneCent;
    
    /**
     * Construct an empty Purse
     */
    public Purse()
    {
        numOneEuro = numFiftyCent = numTenCent = numOneCent = 0;
    }
    
    /**
     * Add count one-cent coins to this purse
     * @param count the number of one-cent coins to add
     */
    public void addOneCentCoins(int count)
    {
        // this is a stub - replace it with your code
        numOneCent += count;
    }
    
    /**
     * Add count ten-cent coins to this purse
     * @param count the number of ten-cent coins to add
     */
    public void addTenCentCoins(int count)
    {
        // this is a stub - replace it with your code
        numTenCent += count;
    }
    
    /**
     * Add count fifty-cent coins to this purse
     * @param count the number of fifty-cent coins to add
     */
    public void addFiftyCentCoins(int count)
    {
        // this is a stub - replace it with your code
        numFiftyCent += count;
    }
    
    /**
     * Add count one-euro coins to this purse
     * @param count the number of one-euro coins to add
     */
    public void addOneEuroCoins(int count)
    {
        // this is a stub - replace it with your code
        numOneEuro += count;
    }
    
    /**
     * Determine the total value of all the coins
     * in this purse
     * @return the total value of the coins in this Purse
     */
    public double getTotal()
    {
        // this is a stub - replace it with your code
        return numOneEuro * ONE_EURO_VALUE +
                numTenCent * TEN_CENT_VALUE +
                numFiftyCent * FIFTY_CENT_VALUE +
                numOneCent * ONE_CENT_VALUE;
    }
    
    /**
     * Get a String representation of this Purse
     * @return a String representation of this Purse
     */
    public String toString()
    {
        // this is a stub - replace it with your code
        return numOneEuro + " one-euro coins\n" +
                numFiftyCent + " fifty-cent coins\n" +
                numTenCent + " ten-cent coins\n" +
                numOneCent + " one-cent coins\n" +
                "[total value: €" + String.format("%.2f", getTotal()) + "]";
    }

    // Extra: add methods to remove coins
    public void remove(double denomination, int count){

        if (denomination == ONE_EURO_VALUE){
            numOneEuro -= count;
        } else if (denomination == FIFTY_CENT_VALUE){
            numFiftyCent -= count;
        } else if (denomination == TEN_CENT_VALUE){
            numTenCent -= count;
        } else if (denomination == ONE_CENT_VALUE){
            numOneCent -= count;
        }

    }
}
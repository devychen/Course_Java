package st10;

/**
 * A class to simulate a coin purse that can hold
 * various denominations of coins.
 * SelfTest
 *
 * @author: mkz
 * TASK: add a method to remove coins from the Purse
 *      which throws a PurseException with an appropriate message
 *      if there are too few coins in the purse
 */

public class Purse
{
    // Instance variables for number of each coin denomination
    private int numOneEuro;
    private int numFiftyCent;
    private int numTenCent;
    private int numOneCent;
    
    /**
     * Add count coins of the given denomination to this purse
     * @param c a Coin object indicating the denomination
     * @param count the number of coins to add
     */
    public void addCoins(Coin c, int count) throws PurseException
    {
        if (count < 0){
            throw new PurseException("Negative number of coins");
        }
        switch (c)
        {
            case ONE_CENT:
                numOneCent += count;
                break;
            case TEN_CENT:
                numTenCent += count;
                break;
            case FIFTY_CENT:
                numFiftyCent += count;
                break;
            case ONE_EURO:
                numOneEuro += count;
                break;
        }
    }

    //--- TODO ----
    /**
     * Remove count coins of the given denomination to this purse
     * @param c a Coin object indicating the denomination
     * @param count count the number of coins to remove
     * @throws PurseException if count is negative or if there are not enough coins
     */
    public void removeCoins(Coin c, int count) throws PurseException {
        if (count < 0){
            throw new PurseException("Negative number of coins");
        }
        switch (c){
            case ONE_CENT:
                if (numOneCent < count){
                    throw new PurseException("Not enough coins");
                }
                numOneCent -= count;
                break;
            case TEN_CENT:
                if (numTenCent < count){
                    throw new PurseException("Not enough coins");
                }
                numTenCent -= count;
                break;
            case FIFTY_CENT:
                if (numFiftyCent < count){
                    throw new PurseException("Not enough coins");
                }
                numFiftyCent -= count;
                break;
            case ONE_EURO:
                if (numOneEuro < count){
                    throw new PurseException("Not enough coins");
                }
                numOneEuro -= count;
                break;
        }

    }

    /**
     * Determine the total value of all the coins
     * in this purse
     * @return the total value of the coins in this Purse
     */
    public double getTotal()
    {
        return ((numOneEuro * Coin.ONE_EURO.getVal()) +
                (numFiftyCent * Coin.FIFTY_CENT.getVal()) +
                (numTenCent * Coin.TEN_CENT.getVal()) +
                (numOneCent * Coin.ONE_CENT.getVal()));
    }
    
    /**
     * Get a String representation of this Purse
     * @return a String representation of this Purse
     */
    public String toString()
    {
        String rval = "";
        
        rval = numOneEuro + " one-euro coins\n" +
            numFiftyCent + " fifty-cent coins\n" +
            numTenCent + " ten-cent coins\n" +
            numOneCent + " one-cent coins\n" +
            "[total value: " + String.format("%.2f", getTotal()) + "]";
        
        return rval;
    }

    // for light testing
//    public static void main(String[] args) {
//        Purse p = new Purse();
//
//        try {
//            p.addCoins(Coin.ONE_CENT, 3);
//            System.out.println(p);
//        } catch (PurseException e) {
//            e.printStackTrace();
//        }
//    }

}
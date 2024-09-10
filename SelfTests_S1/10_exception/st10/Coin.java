package st10;

/**
 * An enumeration to associate coin denominations with values
 */
public enum Coin
{
    ONE_CENT (0.01), TEN_CENT (0.10), FIFTY_CENT (0.50), ONE_EURO (1.0);
    
    private final double val;
    
    Coin(double aVal)
    {
        val = aVal;
    }
    
    double getVal()
    {
        return val;
    }

}
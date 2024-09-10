package st4;

/**
 * @author: mkz
 *
 * TASK: Create and test a class to represent a concert
 *      based on UML class diagram
 */

public class Concert {

    public static final double EPSILON = 0.01;

    private String band;
    private int numSeats;
    private double ticketPrice;
    private int ticketsSold;
    private double totalSales;

    /**
     * sets the name of the band
     * @param band
     */
    public void setBand(String band){
        // stub
        this.band = band;
    }

    /**
     * sets the number of seats
     * @param numSeats
     */
    public void setNumSeats(int numSeats){
        // stub
        this.numSeats = numSeats;
    }

    /**
     * sets the price of a ticket
     * @param ticketPrice
     */
    public void setTicketPrice(double ticketPrice){
        // stub
        this.ticketPrice = ticketPrice;
    }

    /**
     * returns the name of the band
     * @return
     */
    public String getBand(){
        // stub
        return band;
    }

    /**
     * returns the number of seats
     * @return
     */
    public int getNumSeats(){
        // stub
        return numSeats;
    }

    /**
     * returns the price of a ticket
     * @return
     */
    public double getTicketPrice(){
        // stub
        return ticketPrice;
    }

    /**
     * returns the number of tickets sold so far
     * @return
     */
    public int getTicketsSold(){
        // stub
        return ticketsSold;
    }

    /**
     * returns the number of tickets that can still be sold
     * @return
     */
    public int getTicketsLeft(){
        // stub
        return numSeats - ticketsSold;
    }

    /**
     * returns the euro amount of tickets sold
     * @return
     */
    public double getTotalSales(){
        // stub
        return totalSales;
    }

    /**
     * returns true if there are enough tickets left
     *      to sell the requested number
     * @param numTickets
     * @return
     */
    private boolean okToSell(int numTickets) {
        // stub
        return getTicketsLeft() >= numTickets;
    }

    /**
     * sells the requested number of tickets
     *      if there are enough left
     * @param toSell
     */
    public void sellTickets(int toSell){
        // stub
        if(okToSell(toSell)){
            ticketsSold += toSell;
//            totalSales = ticketsSold * ticketPrice;
            // why this is wrong?
            totalSales += toSell * ticketPrice;
        }
    }

    /**
     *  should return a String representing the concert
     *      (include band, ticket price and tickets left)
     * @return
     */
    public String toString(){
        // stub
        String rval = band +
                " ticket price: " + ticketPrice +
                " tickets left: " + getTicketsLeft();
        return rval;
    }

    /**
     * returns true if this Concert is equal to otherConcert.
     *      Two Concerts are equal if
     *      all of their instance variables are equal.
     * @param otherConcert
     * @return
     */
    public boolean equals(Concert otherConcert){
        // stub
        boolean rval = false;

        if (otherConcert != null &&
                this.getBand().equals(otherConcert.getBand()) &&
                this.getNumSeats() == otherConcert.getNumSeats() &&
                Math.abs(this.ticketPrice - otherConcert.ticketPrice) < EPSILON)
        {
            rval = true;
        }

        return rval;

    }
}

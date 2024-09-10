# Self-Test 4

Before you start with this week's selftest, make sure that you have completed (and understood) selftest from last week!

## Exercise:

Today we will create and test a class to represent a concert, depicted in the following UML class diagram:

### Concert
```
- band : String
- numSeats : int
- numTicketsSold : int
- ticketPrice : double
- totalSales : double


+ setBand(String band) : void
+ setNumSeats(int numSeats) : void
+ setTicketPrice(double ticketPrice) : void
+ getBand() : String
+ getNumSeats() : int
+ getTicketPrice() : double
+ getTicketsSold() : int
+ getTicketsLeft() : int
+ getTotalSales() : double
-  okToSell(int numTickets) : boolean
+ sellTickets(int toSell) : void
+ toString() : String
+ equals(Concert otherConcert) : boolean
```

- `setBand` sets the name of the band  
- `setNumSeats` sets the number of seats  
- `setTicketPrice` sets the price of a ticket  
- `getBand` returns the name of the band  
- `getNumSeats` returns the number of seats  
- `getTicketPrice` returns the price of a ticket  
- `getTicketsSold` returns the number of tickets sold so far  
- `getTicketsLeft` returns the number of tickets that can still be sold  
- `getTotalSales` returns the euro amount of the tickets sold  
- `okToSell` returns true if there are enough tickets left to sell the requested number  
- `sellTickets` sells the requested number of tickets if there are enough left  
- `toString` should return a String representing the concert (include band, ticket price and tickets left)  
- `equals` returns true if *this* Concert is equal to *otherConcert*.  Two Concerts are equal if all of their instance variables are equal. In the statement `concert1.equals(concert2)`, `concert1` is the calling object (*this*) and `concert2` is *otherConcert*.

Write a stub for each method, like this:
```
public void setBand(String band)
{
    // stub - replace with code
}

public String getBand()
{
    // stub - replace with code
    return null;
}
```

Start filling in the method bodies.  
There are some junit tests provided for you in class `ConcertTest.java`.  
**Compile and test often**.

One test has not been implemented (`testGetTotalSales2`).  
Write this test so that it buys tickets at different prices (for example 4 tickets at €32.50 and 2 tickets at €27.00), then makes an assertion about the expected sales amount.



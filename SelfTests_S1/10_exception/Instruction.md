
# Self-Test 10

## Exceptions

Today we are going to add exception handling code to a `Purse` class (similar to *SelfTest 3*, but modified to use an enumeration for the coins) and develop junit tests for it.

Start with these class definitions: `Purse.java`, `PurseTest.java`, `Coin.java`

Coin is an enumeration class. It is used to associate a constant with a value (eg ONE_CENT is associated with the double value 0.01).

Take a look at the `Purse` class to see how to use the `Coin` enumeration.

## Exercise

- Write an exception class `PurseException`.
- Throw a PurseException in the `addCoins` method if the input parameter count < 0
- Add the following annotation to the javadoc comments for the addCoins method: 
`@throws` PurseException if count is negative

Now take a look at the `PurseTest class`. The first test looks like this:

```
/**
 * Test the AddCoins method.
 */
 public void testAddCoins() {
      Purse myPurse = new Purse();
      assertEquals(0, myPurse.getTotal(), EPSILON);

      try {
          myPurse.addCoins(Coin.ONE_CENT, 1);
          assertEquals(0.01, myPurse.getTotal(), EPSILON);
    
          myPurse.addCoins(Coin.ONE_CENT, 100);
          assertEquals(1.01, myPurse.getTotal(), EPSILON);
      } catch (PurseException e) {
          fail("Exception should not be thrown");
      }
 }
```

An exception should not be thrown because in both calls the count argument is positive (1 and 100).  If an exception gets thrown, it will be caught and cause the test to fail by calling the fail method.

- We also need to make sure that an exception does get thrown if the argument is negative. This test fails if no exception gets thrown, and passes if one IS thrown:

```
/**
* Test the AddCoins method - negative argument.
*/
public void testAddCoinsNeg() {
    Purse myPurse = new Purse();
    try {
            myPurse.addCoins(Coin.TEN_CENT, -1);
            fail("Exception should have been thrown");
    } catch (PurseException e) {
            // good, this is what we want
    }
}
```
- Add another method to **Purse.java** to remove coins from the Purse which throws a PurseException with an appropriate message if there are too few coins in the purse. Hint: you can throw an exception in more than one place in a method.
- Write tests for your new method (no exceptions, negative argument, too few coins)

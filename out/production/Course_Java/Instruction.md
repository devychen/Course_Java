## Before you start:
Read EVERYTHING up to `Ok, enough reading!` before you write any code.

## Exercise (part I):

Today we will define a class called **Purse** to simulate a bag with coins in it.  We want to be able to add coins to a Purse, get the total value of the coins in a Purse, and to get a String representation of a Purse (a String object indicating how many of each coin denomination are contained in the purse and their total value).  To simplify the problem, we will have only 1-cent, 10-cent, 50-cent, and 1-euro coins in a Purse.

Now look at Purse.java :

There are 4 instance variables to store the number of coins of each denomination in a Purse:
- numOneEuro 
- numFiftyCent 
- numTenCent 
- numOneCent

When coins are added to a Purse, the number of coins of that denomination is increased.

Notice that there is a funny method with no return type (public Purse()).  This is actually not a method - it is called a constructor.  We will learn all about constructors soon.  All you need to know now is that when you create a Purse object, the instance variables are all initialized to 0 by the constructor (i.e. a new Purse contains no coins).

Also notice that the body of each method is just a stub - it does nothing. If a method is expected to return a value, it returns a meaningless value.  This allows us to write JUnit-tests for our methods before they are fully implemented.

Now look at a JUnit test file for the Purse class PurseTest.java :

PurseTest is a class with a bunch of methods called testSomething.  Each test method creates a Purse object, calls one or more methods in the Purse class, and makes some assertion(s) about the value returned by some method call.  If the expected value matches the actual value returned, then the program has behaved correctly and the test passes.

The first test looks like this:
```java
    public void testAddOneCentCoins()
    {
        Purse myPurse = new Purse();
        assertEquals(0, myPurse.getTotal(), EPSILON);
      
        myPurse.addOneCentCoins(1);
        assertEquals(0.01, myPurse.getTotal(), EPSILON);
       
        myPurse.addOneCentCoins(100);
        assertEquals(1.01, myPurse.getTotal(), EPSILON);
    }
```

Since a new Purse object has no coins, we expect the getTotal to return 0.  The test creates a new Purse object and asserts that the value returned by the getTotal method is 0, with an error margin of EPSILON. Since we are comparing doubles we need to allow for some error in the fractional part, but the values should always be within 1 cent (0.01) of each other.  If the getTotal method really does return 0, the test will continue by adding 1 1-cent coin to the Purse. If getTotal now returns 0.01 (i.e. one cent) the test continues by adding 100 1-cent coins. Now the total value should be 1.01.  If any of the assertions are false, the test will fail - which means there is something wrong with the getTotal method that needs to be fixed.

### ! - - - Ok, enough reading - - - !  
### Let's get started.

Compile both Purse.java and PurseTest.java and run the tests by clicking the "Test" button.  All tests fail, but that's not surprising because our method bodies have not been implemented yet.

Each method in the Purse class has a javadoc comment that explains what the method should do.  Replace the method body stubs  with appropriate code.  Compile and test often, until all tests pass (they will show up green instead of red).

There is no test for the toString method, but implement it anyway. If a Purse contains 2 of each coin denomination, the toString method should return a String that looks something like this:
```
2 one-euro coins
2 fifty-cent coins
2 ten-cent coins
2 one-cent coins
[total value: €3.22]
```

## Exercise (part II):
Congratulations!  All the tests passed!

Write a small demo program called PurseDemo that creates 2 purses and adds coins to them:
- create 2 Purse objects
- add coins of various denominations to each purse
- print both with `System.out.println(NameOfYourPurseObject);`
- add more coins and print again 

Compile and run your program - make sure the output looks reasonable.

Trick for formatting doubles:
```java
String.format("%.2f", doubleVar); 
// creates a String from doubleVar, with 2 digits after the decimal point
```
Try it out in the interactions pane (notice that it rounds, rather than truncates):
```java
String.format("%.2f", 5.929);
String.format("%.2f", 5.999);
String.format("%.4f", 5.98765);
```
## Exercise (part III):
If time permits, add methods to remove coins from the purse, 
and tests for the new methods.  

What will you do if the number of coins to be removed 
is greater than the number of coins in the purse? 
We will learn a good way to deal with such problems later.  
For now, just ignore the request and do nothing in this case. 

Note: calling System.out.exit(0) will make it impossible to 
write Junit tests, so don't do that...
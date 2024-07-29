## Exercise 1
A store wants a program `TaxProgram` that calculates the tax on an item of clothing. An item that costs Euro 100 or more has a 5% tax.

For an item that costs less than Euro 100 the customer must not pay taxes.

Write a program that asks for a price, calculates the tax, then prints the price, the tax and the total cost.

For now, we don't care that the tax or the total is calculated wrong sometimes. We will learn how to do a proper rounding later this semester.

### Example output:
```
Enter the price: 120
Item cost: 120.0 Tax: 6.0 Total: 126.0
Enter the price: 56
Item cost: 56.0 Tax: 0.0 Total: 56.0
Enter the price: 114.67
Item cost: 114.67 Tax: 5.7335 Total: 120.40350000000001
```
**(4 points)**


## Exercise 2
Write a program `UpcaseSuffix.java` which reads a word `w` and an integer `l` and outputs word `w` with the last `l` characters in upper case.

Add comments that describe the flow of your program and don't forget the usual program header.

Please make sure that integer `l` is in the bounds of word `w`. Print an error message if `l` is outside the bounds of `w`.

### Example output:
```
Enter a word
Directory
Enter a number
4
DirecTORY
```
**(4 points)**
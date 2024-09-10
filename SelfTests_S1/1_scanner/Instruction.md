## Exercise 1:
English words can be translated into a language "pig latin" by moving the first letter of the word to the end of the word and adding "ay".

For example,  "Happy Halloween" in pig latin is: "Appyhay Alloweenhay"
Write a program called **PigLatin** that asks the user for their first and last name and prints their full name in pig latin.  Don't forget to capitalize the first letter of the first and last names - the rest of the name should be lowercase.


## Exercise 2:
In a new role-playing fantasy game players must design their character by picking a point value for each of three characteristics:

- Strength, from 1 to 10
- Intelligence, from 1 to 10
- Luck, from 1 to 10
Write a program that asks for a name for the character and asks for a point value for each of the three characteristics. However, the total points must be less than 16. If the total exceeds 15, then 5 points are assigned to each characteristic.

Sample run:
```
Enter the name of your character: Chortle
Enter strength (1-10): 8
Enter intelligence (1-10): 4
Enter luck (1-10): 6
```

You have given your character too many points! Default values have been assigned:
Chortle [strength: 5, intelligence: 5, luck: 5]

## Exercise 3 (optional):
Exercise 2 ignored the possibility that the user's input for the three variables might not be between 1 and 10.
Extend your program in such a way that it notifies the user in case at least one of the variables is not in the admitted range, and assigns the default value 5 to each variable.
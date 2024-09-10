# Self-Test 7 - Multi-Dimensional Arrays

## Exercise:

This self test will span two class sessions. You will implement the popular `Levenshtein distance algorithm` that we have already discussed during the lecture (see slides ch07+levenshtein.pdf)

The Levenshtein distance algorithm is used to measure the difference (distance) between 2 strings. 
The lower the distance the more similar the 2 input words are. 
For example, the distance between
- stop and shop is 1;
- power and owner is 2;
- task and program is 7.

The distance between 2 strings is determined by the minimum number of operations needed to transform one string into the other using the operations of insertion, deletion, and substitution of a single character. For example, the distance between "kitten" and "sitting" is 3:
- kitten -> sitten (substitute 's' for 'k')
- sitten -> sittin (substitute 'i' for 'e')
- sittin -> sitting (insert 'g' at the end)

Whereas the distance between "ape" and "face" is 2:
- ape -> fape (insert 'f')
- fape -> face (substitute 'c' for 'p')

Create a class file `Levenshtein.java` that has the following instance variables:
- `private String word1`
- `private String word2`
- `private int[][] table`

`Levenshtein.java` should contain the following methods:

- `public Levenshtein(String aWord1, String aWord2):` 
Constructor. Initializes all instance variables and creates the table using the static helper method.
- `private static int[][] table(String word1, String word2):`
Constructs and returns the table as a two-dimensional integer array. 
Should be used in the constructor to create the table. This is the actual implementation of the algorithm.
- `private static int min(int i1, int i2, int i3):` calculates (returns) the mathematical minimum of three integer numbers (parameters).
- `public int distance():` Returns the Levenshtein distance between word1 and word2.
- `public void printTable():` prints `table` (two-dimensional array). (optional: print the table with the two words in their correct positions in the first row and first column respectively.)
- `main` method which reads two words from the user to compare for their Levenshtein distance (it should continue to do so until the user enters "q").

The algorithm implementation should use a two-dimensional array. This array needs to be initialized as follows:
- Initialize the table one element longer than string 1 and one element wider than string 2.
- Initialize column 0 by values 0, 1, 2, ...
- Initialize row 0 by values 0, 1, 2, ...
- The rest of the table is filled as follows: `min(left + 1, above + 1, aboveLeft + subst);` where `left` is the field to the left, 
`above` is the field above, 
`aboveLeft` is the field left-above, 
and `subst` is either 0 (if the characters are the same) or 1 (if the characters are different). 
For more details about these values, see the slides.

The final result of the distance computation is the value in the lowest right cell of the two-dimensional array. Make sure to print the two-dimensional array once it is filled with values.
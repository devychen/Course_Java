# Self-Test 6

## Before you start:

Take a look at StringList and StringListDemo (downloadable from the Examples link), which is an example of how an array can be used as an instance variable.

## Exercise (part 1):
A lexical unit contains information about a word. What information it contains depends on how it is intended to be used. Often it contains a word, a part-of-speech, a definition, example sentences, information about relationships to other words (synonyms, antonyms,...). We'll just include the word itself and synonyms for now.

Define a class called LexUnit to represent a lexical unit with a wordForm and synonyms, described by the UML diagram:

### LexUnit
```
-  wordForm : String
-  synonyms : String[]
-  numSynonyms : int


+ getWordForm() : String
+ setWordForm(String wordForm) : void
+ getSynonyms() : String[]
+ getNumSynonyms() : int
+ addSynonym(String aSynonym) : void
+ toString() : String
```


### Method descriptions:

`public String getWordForm()`
Return the wordForm for this LexUnit  
`public void setWordForm(String wordForm)`
Set the wordForm for this LexUnit  
`public String[] getSynonyms()`	
Return the synonyms for this LexUnit; 
it should return a copy of the used portion of the synonym array  
`public int getNumSynonyms()` 
Return the number of synonyms for this LexUnit   
`public void addSynonym(String aSynonym)`
Add aSynonym to this LexUnit's synonyms; 
if the array is not big enough to hold another element, 
resize the array before adding
`public String toString()`
Generate and return a String containing the word form, 
the number of synonyms, and the synonyms

Add two constructors (both should start out with a synonym array of length **2**):

`public LexUnit()`
Default constructor to initialize the instance variables 
so that the LexUnit has no wordForm and no synonyms
`public LexUnit(String wordForm)`
Constructor to initialize the instance variables 
so that the LexUnit has the given wordForm but no synonyms

## Exercise (part 2):
Now write a program called `LexUnitDemo` that creates an array of LexUnits. Repeatedly prompt the user to enter a wordForm and its synonyms, create a LexUnit with this information, and add the LexUnit to your array.
Print all LexUnits in the array.

Note that this array may also become full at some point 
- add code to resize it if necessary.

- Adding a 3rd synonym for a LexUnit should cause your resizing code to be executed. 
- Make sure your demo program calls each method in the LexUnit class at least once. If you implemented the toString method correctly you should be able to print a LexUnit called lex1 with one of the following print statements:

```java
// println method automatically calls the
// toString method of lex1
System.out.println(lex1);

// this does the same thing, but calls
// toString directly:
System.out.println(lex1.toString());
```
Sample LexUnitDemo output:

```
You entered the following LexUnits:
realize: recognize understand see
theater: playhouse
color: dye pigment tinge tint
```
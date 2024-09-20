## Something completely different

Usually when you are writing an exception class, you stick to a certain template and change only a few messages and the name of the exception class.

Due to these repetitive steps in creating exception classes, it would actually be easy to write a program that can create an exception class for us. The only input we need is the name of the class and the default message.

If we look at the examples given by Savitch, it might become even easier. A **DivideByZeroExeption** has a *Dividing by Zero Exception* message,
a **NegativeNumberException** has the message *Negative Number Exception*.

**_What we have to do to get the name of the exception class, is to take the message
and remove all the blanks. If the message does not end with "Exception", we append "Exception"._**


## Example

| Input        | Exception name           | Message  |
| ------------- |:-------------:| -----:|
| Wrong Social Security Format      | WrongSocialSecurityFormatException| Wrong Social Security Format Exception |
| Java Gives Headache      | JavaGivesHeadacheException      |   Java Gives Headache Exception |
| Java Gives Headache Exception | JavaGivesHeadacheException      |    Java Gives Headache Exception |


## Algorithm

The basic idea for our generator is to write the messages for the exception classes we want to generate, one message per line, into a file and run the ExceptionGenerator on that file.
The generator reads the messages line by line from the file given as a commandline argument, builds the class name from the message, opens the output file, writes code to the output file, closes it and goes to the next line.

Here is a stepwise description of the approach:

```
1. Check for the correct number of command line arguments
2. Open the input file with filename given in args[0]
3. For every line in the input file
 	3.1. Read a line
 	3.2. Create name of the new exception class
 	3.3. Create name of the output file 
 	3.4. Create output file for the Java code
 	3.5. Write code to the output file
 	3.6. Close the output file
```

## Exercise 1

Write a program ExceptionGenerator that implements the above algorithm. (Or an improved version of it). The generated exception classes must compile.
You'll find a sample input file in `sample-input.txt`.
To run a program on a file, you type `java ProgramName "FileName"` in the command line (or in DrJava: in the Interactions Pane), i.e. in this case `java ExceptionGenerator "sample-input.txt"`.
The file name will then be used as an argument for your main method.
When you run your program on this file, the following Java files should be created:

* `WrongSocialSecurityFormatException.java`

* `JavaGivesHeadacheException.java`


You should develop and debug in several steps. You should go on to the next step **ONLY** if you've finished working on the previous one. We suggest testing your code after each of the following steps and proceeding to the next one only if so far everything worked as expected:

1. **Check for the correct number of command line arguments**

   The only argument of the ExceptionGenerator is a filename. So the number of arguments must be 1.
   Print out the contents of args[0] to be sure that the name of the file is correct.

2. **Open the input file from filename given in args[0]**

   Make sure that you can open the file and that no exceptions are generated.

3. **For every line in the file**

   Create a message and print it to stdout.
   If this works, create the class names and print them.
   Build the filenames for the output files and print them.

4. **Open output files and write code into the files.**

**(10 points)**
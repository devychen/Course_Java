
## Exercise 1:
Write a program  that computes xn  where  x and n are both integers and n is positive. Prompt the user for x and n (print an error message and exit the program on bad input). <br>

```
x^n = x * x * x * ... * x   
      |-------------------|
            n times
```

Recall that x^0 = 1 for any x.


## Exercise 2:
When we wrote the original PigLatin program, I simplified the rules because we didn't know about if's and loops back then.  Modify your PigLatin program so that it reads lines of text (till the end of input) and translates each word on each line to pig latin, using the following rules:
- All of the consonants at the beginning of a word are moved to the end and "ay" is attached 
- If a word begins with a vowel, nothing is moved to the end.  Simply attach "lay" to the end.
- 'y' is not considered a vowel (just 'a', 'e', 'i', 'o', and 'u')
- Assume that all input is lowercase 
- Assume that the input contains no punctuation.

Sample input:
```
once upon a time there were three little pigs
who lived with their mother
one day the mother said to her little pigs
it is time for you to strike out on your own
```

output:
```
oncelay uponlay alay imetay erethay ereway eethray ittlelay igspay
owhay ivedlay ithway eirthay othermay
onelay ayday ethay othermay aidsay otay erhay ittlelay igspay
itlay islay imetay orfay ouyay otay ikestray outlay onlay ouryay ownlay
```

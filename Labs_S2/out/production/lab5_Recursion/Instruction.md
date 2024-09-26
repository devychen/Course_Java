# Lab 5

## Palindrome
BrE 'palɪndrəʊm'

A palindrome is a string that reads the same forwards and backwards. For example: "Anna" and "sfs" are palindromes while "Anne" and "sfb" are not.

### Exercise 1

In `Palindrome.java`, implement a recursive function `public static boolean isPalindromeRecursive(String text)`. This method will `return true` when `text` is a palindrome and 
`false` otherwise.

When you compare characters, make sure you do a case-insensitive comparison.

Do not consider punctuation or white space, eg: "Red roses run no risk, sir, on nurses order." should return true.

Do consider numbers, eg: "I was 1 or Ro 2 saw I" should return false, and "I was 1 or Ro 1 saw I" should return true.

Your code should be able to handle null. 

### Exercise 2

Complete `public static boolean isPalindromeIterative(String text)` in your `Palindrome` class which implements an iterative version of `isPalindromeRecursive(String text)`.


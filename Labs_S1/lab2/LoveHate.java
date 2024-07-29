/**
 * @author Max
 *
 * Task: complete the missing codes
 *
 * This program does the following:
 * Reads in a line of text then outputs the line with the first occurrence of the word "hate" changed to the word "love."
 *
 * Assumptions:
 * - The line of text has at least one occurrence  of the word "hate"
 * - The word "hate" is all lower case.
 */

import java.util.Scanner;

public class LoveHate
{
    public static void main(String[] args)
    {
		/*
			Create a new Scanner object 'keyboard' and connect it to stream
			System.in
		*/
        Scanner keyboard = new Scanner(System.in); // TODO

		/*
			Print prompt.
		*/
        System.out.println("Enter a line of text with the word \"hate.\"");

        /*
			Read a line from 'keyboard' and store it in variable 'sentence'
		*/

        String sentence = keyboard.nextLine(); // TODO

		/*
			Search for the first occurrence of substring 'hate' in 'sentence'
		*/

        System.out.println("I have rephrased that line to read: ");

		/*
			Replace the substring we have just found with string 'love' and
			print the changed sentence to System.out.
		*/




    }
}
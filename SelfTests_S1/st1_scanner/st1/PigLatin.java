package st1;

/**
 * @author: mkz
 * St1, Ex1
 * Task: ask for user's first & last name and
 *      print full name into pig-latin -
 *      move 1st letter to the end of word and adding "ay",
 *      eg. Happy Halloween - Appyhay Alloweenhay
 */

import java.util.Scanner;

public class PigLatin {

    public static void main(String[] args) {

        String firstNamePL, lastNamePL, firstName, lastName;
        String suffix = "ay";

        // ask for inputs
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your first name:");
        firstName = sc.nextLine().toLowerCase();

        System.out.println("Please enter your last name:");
        lastName = sc.nextLine().toLowerCase();

        // transform
        firstNamePL = Character.toUpperCase(firstName.charAt(1)) + // 2nd Char Capitalise
                firstName.substring(2, firstName.length()) + // keep substring
                firstName.charAt(0) + // old 1st Char now to the last
                suffix; // add "ay"

        lastNamePL =  Character.toUpperCase(lastName.charAt(1)) +
                lastName.substring(2, lastName.length()) +
                lastName.charAt(0) +
                suffix;

        // output
        System.out.println(firstNamePL + " " + lastNamePL);

        sc.close();
    }
}

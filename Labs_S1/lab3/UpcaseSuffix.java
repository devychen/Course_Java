import java.util.Scanner;

/**
 * @author Mackenzie
 *
 * Task:
 * a pogramme to read a word w and an integer l
 * and outputs word w
 * with the last l characters in upper case.
 *
 * Make sure int l is in the bounds of word w.
 * Print an error message if outside.
 *
 * ** Example Output
 * Enter a word
 * Directory
 * Enter a number
 * 4
 * DirecTORY
 * -----
 * 012345678
 * length = 9, ie `length()-1`
 *
 */

public class UpcaseSuffix {
    public static void main(String[] args) {

        // read the word & int
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a word"); // input prompt
        String w = input.nextLine();

        System.out.println("Enter a number"); // input prompt
        int l = input.nextInt();


        // transform and print
        if (l >= 0 && w.length() >= l){
            w = w.substring(0, l+1) + w.substring(w.length()-l).toUpperCase();
            System.out.println(w);
        } else {
            System.out.println("Please enter a valid number."); // error msg
        }


    }


}

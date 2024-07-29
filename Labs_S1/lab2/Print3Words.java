import java.util.Scanner;

/**
 * @author Mac
 *
 * Task:
 *
 * **Example Output**
 * Enter three words: Hello lovely world
 *
 * Word one as upper case: HELLO
 * Second word as lower case: lovely
 * First two characters of word three: wo
 */

public class Print3Words {

    public static void main(String[] args) {

        System.out.print("Enter three words: ");
        Scanner keyboard = new Scanner(System.in);
        // read the input three words
        if(keyboard.hasNext()) {
            String w1 = keyboard.next();
            String w2 = keyboard.next();
            String w3 = keyboard.next();

            // transforming words
            String new_w1 = w1.toUpperCase();
            String new_w2 = w2.toLowerCase();
            String new_w3 = w3.substring(0,2); // end index NOT included

            // output
            String s1 = "Word one as upper case: ";
            String s2 = "Second word as lower case: ";
            String s3 = "First two characters of word three: ";
            System.out.println(); // extra empty line
            System.out.println(s1 + new_w1);
            System.out.println(s2 + new_w2);
            System.out.println(s3 + new_w3);
        } else {
            System.out.println("Nothing entered");
        }


    }
}

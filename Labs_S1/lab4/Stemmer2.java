import java.util.Scanner;

/**
 * @author: mkz
 *
 * If not using helper method class
 *
 * Example line:
 * motoring sing caresses caress ponies cats feed agreed plastered bled
 */

public class Stemmer2 {

    public static void main(String[] args) {

        // read the input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your words in the following line: ");
        String wordlist = input.nextLine();

        // read the input by tokens
        Scanner wordReader = new Scanner(wordlist);

        while (wordReader.hasNext()){

            String word = wordReader.next();
            String stem = "";

            // If the word ends in "ing" and is longer than 4 letters, remove the "ing".
            if (word.endsWith("ing") && word.length() > 4) {
                stem = word.substring(0, word.length() - 3);
            }
            // If the word ends in "sses", remove the final "es".
            else if (word.endsWith("sses")) {
                stem = word.substring(0, word.length() - 2);
            }

            // If the word ends in "ies", replace the "ies" with "y".
            else if (word.endsWith("ies")) {
                stem = word.replace("ies", "y");
            }

            // If the word ends in "s", but not in "sses", "ies", or "ss", then remove the final "s".
            else if (word.endsWith("s") && !word.endsWith("sses") && !word.endsWith("ies") && !word.endsWith("ss")
            ) {
                stem = word.substring(0, word.length() - 1);
            }

            // If the word ends in "eed" and is longer than 4 letters, remove the final "d".
            else if (word.endsWith("eed") && word.length() > 4) {
                stem = word.substring(0, word.length() - 1);
            }

            // If the word ends in "ed" but not in "eed" and is longer than 4 letters, remove the final "ed".
            else if (word.endsWith("ed") && !word.endsWith("eed") && word.length() > 4) {
                stem = word.substring(0, word.length() - 2);
            }

            else{
                stem = word;
            }

            System.out.println(word + " - " + stem);



        }

        // close Scanner
        input.close();
        wordReader.close();
    }



}

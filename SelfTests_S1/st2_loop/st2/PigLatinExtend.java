package st2;

/**
 * @author: csy
 *
 * Task: extend PigLatin programme with loops
 *
 */

import java.util.Scanner;

public class PigLatinExtend {
    public static void main(String[] args) {

        // prompt
        System.out.println("Please enter the text to be transformed: ");

        // initialise
        String line = "";
        String word = "";
        String plWord = "";

        // read line
        Scanner sc = new Scanner(System.in);
        Scanner lineScan;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            lineScan = new Scanner(line);

            // start output from next line
            System.out.println();

            // read words
            while (lineScan.hasNext()) {
                word = lineScan.next();

                // transform

                // detect head, obtain the index of 1st vowel
                boolean isVowel = false;
                int firstVowelIndex = 0;
                char currentLetter;
                while (firstVowelIndex < word.length() && !isVowel) {
                    currentLetter = word.charAt(firstVowelIndex);
                    switch (currentLetter) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            isVowel = true;
                            break;
                        // if not vowel, loop to next to look for it
                        default: // why - USAGE: if not case match, then
                            firstVowelIndex++;

                    }
                }

                // if word begins with a vowel
                if (firstVowelIndex == 0){
                    plWord = word + "lay"; // simply attach "lay" to the end
                } else { // if begins with a consonant
                    plWord = word.substring(firstVowelIndex, word.length()) + // from 1st vowel to word end
                            word.substring(0, firstVowelIndex) + // from head to 1st vowel (excluded)
                             "ay";
                }
                System.out.print(plWord + " ");
            }
        }
        sc.close();
    }
}

// why
//  在没有写"&& !isVowel"的时候，程序一直在等待我进一步输入，为什么加入这句后就解决了




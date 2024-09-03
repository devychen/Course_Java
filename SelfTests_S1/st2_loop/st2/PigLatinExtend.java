package st2;

import java.util.Scanner;

public class PigLatinExtend {
    public static void main(String[] args) {

        // initialise
        String input;
        String line, word;

        // prompt
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                word = lineScan.next();
                for (int i = 0; i < word.length(); i++) {

                }

            }

        }


    }
}

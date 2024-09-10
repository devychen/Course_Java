package st7;

import java.util.Scanner;

/**
 * @author mkz
 * TASK: create a class to implement levenshtein algorithm
 */

public class Levenshtein {

    private static final String SEP_BLOCK = "+\u2014\u2014\u2014";

    // instance variables
    private String word1, word2;
    private int[][] table;

    // methods - constructors

    /**
     * Constructor.
     *      Initializes all instance variables and
     *      creates the table using the static helper method.
     * @param aword1 The first word for levenshtein
     * @param aword2
     */
    public Levenshtein(String aword1, String aword2) {
        word1 = aword1;
        word2 = aword2;
        table = table(word1, word2);
    }

    // methods - helper methods

    /**
     * Constructs and returns the table as a two-dimensional integer array.
     * Should be used in the constructor to create the table.
     * This is the actual implementation of the algorithm.
     *
     * @param word1
     * @param word2
     */
    private static int[][] table(String word1, String word2) {

        int[][] table = new int[word1.length() + 1][word2.length() + 1];
        // initialise column 0 (ie 1st column) and row 0, fill in with [0, 1, 2, 3,...]
        for (int row = 0; row < table.length; row++) { // 即行数
            table[row][0] = row;
        }
        for (int column = 0; column < table[0].length; column++) { // 列数
            table[0][column] = column;
        }
        // fill the rest with algorithms
        for (int row = 1; row < table.length; row++) {  // for every row...
            for (int column = 1; column < table[0].length; column++) { // fill in every column

                // based on pairs of char to be compared...
                char c1 = word1.charAt(row - 1);
                char c2 = word2.charAt(column - 1);

                // calculate values for surrounding cells
                int left      = table[row  ][column-1];
                int above     = table[row-1][column  ];
                int leftAbove = table[row-1][column-1];
                int substCost = (c1==c2) ? 0 : 1; // 0 if same, 1 if different
                table[row][column] = min(left+1, above+1, leftAbove + substCost);
            }
        }
        return table;
    }

    /**
     * Calculates (returns) the mathematical minimum
     *      of three integer numbers (parameters).
     * @param i1 integer number 1
     * @param i2 integer number 2
     * @param i3 integer number 3
     * @return the minimum value
     */
    private static int min(int i1, int i2, int i3){
        return Math.min(i1, Math.min(i2, i3));
    }

    /**
     * Returns the Levenshtein distance between word1 and word2.
     * @return
     */
    public int distance(){
        return table[word1.length()][word2.length()]; // value at right bottom
    }

    /*
     * Returns the initial row of the pretty printed table.
     * returns:
     * "|   |   | w | o | r | d | 2 |"
     */
    private String initialRowString() {
        StringBuilder s = new StringBuilder();
        s.append("|   |   ");
        for (int i = 0; i < word2.length(); i++) {
            s.append("| " + word2.charAt(i) + " ");
        }
        s.append("|");
        return s.toString();
    }

    /*
     * Returns a separator line of the pretty printed table.
     * returns:
     * "+---+---+---+---+---+---+---+"
     */
    private String separatorLine() {

        StringBuilder s = new StringBuilder();
        s.append(SEP_BLOCK);
        s.append(SEP_BLOCK);
        for (int i = 0; i < word2.length(); i++) {
            s.append(SEP_BLOCK);
        }
        s.append("+");
        return s.toString();
    }

    /*
     * Returns the row with index rowIndex of the pretty printed table.
     * i.e. returns:
     * "| d | 4 | 3 | 2 | 1 | 0 | 1 |"
     */
    private String rowString(int rowIndex) {
        StringBuilder s = new StringBuilder();
        if (rowIndex == 0)   // no char yet -> " "
            s.append("|   ");
        else
            s.append("| " + word1.charAt(rowIndex-1) + " ");
        for (int num : table[rowIndex]) {
            s.append("|");
            if (num/10 < 1) {           // keep it pretty for double digit numbers
                s.append(" ");
            }
            s.append(num + " ");
        }
        s.append("|");
        return s.toString();
    }

    /**
     * Pretty prints the table to the screen.
     *
     * output:
     * "+---+---+---+---+---+---+---+
     *  |   |   | w | o | r | d | 2 |
     *  +---+---+---+---+---+---+---+
     *  |   | 0 | 1 | 2 | 3 | 4 | 5 |
     *  +---+---+---+---+---+---+---+
     *  | w | 1 | 0 | 1 | 2 | 3 | 4 |
     *  +---+---+---+---+---+---+---+
     *  | o | 2 | 1 | 0 | 1 | 2 | 3 |
     *  +---+---+---+---+---+---+---+
     *  | r | 3 | 2 | 1 | 0 | 1 | 2 |
     *  +---+---+---+---+---+---+---+
     *  | d | 4 | 3 | 2 | 1 | 0 | 1 |
     *  +---+---+---+---+---+---+---+
     *  | 1 | 5 | 4 | 3 | 2 | 1 | 1 |
     *  +---+---+---+---+---+---+---+"
     */
    public void printTable() {
        // first row: word2 (above the actual table)
        System.out.println(separatorLine());
        System.out.println(initialRowString());
        System.out.println(separatorLine());

        // prints each row in table followed by a separator line
        for (int row = 0; row < table.length; row++) {
            System.out.println(rowString(row));
            System.out.println(separatorLine());
        }
    }

    /**
     *  reads two words from the user to compare for their Levenshtein distance
     *          (it should continue to do so until the user enters "q").
     * @param args
     */
    public static void main(String[] args) {
        // copy from solutions
        Scanner keyboard = new Scanner(System.in);
        String word1, word2;
        Levenshtein lev;

        System.out.println("Welcome to Levenshtein!");

        while (true)
        {
            System.out.println("Enter two words! ('q' to quit)");

            // read two words
            word1 = keyboard.next();

            if (word1.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                keyboard.close();
                break;
            }

            word2 = keyboard.next();
            keyboard.nextLine();

            lev = new Levenshtein(word1, word2);
            lev.printTable();
            System.out.println("Levenshtein distance: " + lev.distance() + "\n");
        }
        keyboard.close();
    }

}

package dsa2_st5;

/**
 * @author mkz
 * Description:
 */

public class PascalTriangle {

    // a recursive method to determine the number of handshakes for the input params n
    // n>=0 ppl in the room, each shakes once with others.
    public static int handshake(int n) {
        // has ppl
        if (n < 0) throw new IllegalArgumentException("n must be positive");
        // base case
        if (n <= 1) return 0;
        else return handshake(n-1) + (n - 1);
    }


    // returns the row of pascal's triangle in an array of ints
    // n is the row number, starting from 0
    public static int[] pascal(int n){
        // valid n
        if (n < 0) throw new IllegalArgumentException("n must be positive");

        // base case
        if (n == 0) return new int[]{1};

        // recursive case
        int[] curRow = new int[n+1]; // row n has n+1 elements (length)
        curRow[0] = curRow[n] = 1; // set 1st and last elements to 1
        int[] prevRow = pascal(n-1);
        for (int i = 1; i < n; i++){ // from first element to the last(exclusive)
            curRow[i] = prevRow[i-1] + prevRow[i];
        }
        return curRow;

    }

}

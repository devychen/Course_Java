package examples;

/**
 * @author mkz
 * Description: return the number of zeros in the integar
 *  How? Getting the number of zeros contained in
 *  all but the last digit, then add 1 if the last digit is a zero.
 */

public class NumZeros {

    public static int numZeros(int n) {

        // Base case: if the number is 0, return 1 (there's one zero).
        if (n == 0) {
            return 1;
        }

        // Base case: if the number is a single digit and not zero, return 0.
        if (n < 10) {
            return 0;
        }

        // If the last digit is zero, we count it and recurse on the rest of the number.
        if (n % 10 == 0) {
            return numZeros(n / 10) + 1;
        } else {
            // Otherwise, we simply recurse on the rest of the number without adding a zero count.
            return numZeros(n / 10);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(numZeros(10500)); // Output: 3
        System.out.println(numZeros(0));     // Output: 1
        System.out.println(numZeros(7));     // Output: 0
    }
}

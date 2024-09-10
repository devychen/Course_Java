package st2;

import java.util.Scanner;

/**
 * @author: mkz
 * TASK: compute xn,
 *      x & n are integers, n >= 0
 *      (Recall x^0 = 1)
 */

public class Computation {

    public static void main(String[] args) {

        // initialise
        int x, n;
        int result = 1;
        // why【注意】这里写0的时候，最后结果永远是0。
        //  因为0乘以任何数都是0

        // prompt input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of x: ");
        x = sc.nextInt();
        System.out.println("Enter the value of n (n≥0): ");
        n = sc.nextInt();

        // compute
        // n = 0
        if (n == 0) {
            result = 1;
        } else if (n < 0 || x < 0){
            System.out.println("Bad input. Programme exits.");
            System.exit(0);
        } else {
            for (int i = 1; i <= n; i++) {
                result = result * x; // or `result *= x;`
            }
        }

        // output
        System.out.println("The result is: " + result);

        sc.close();

    }

}

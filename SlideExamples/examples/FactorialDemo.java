package examples;

/**
 * @author mkz
 * Description: a program to do factorial calculation
 */

public class FactorialDemo {

    public static int factorial(int n) {
        if (n == 1){
            return n;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }
}

/**
 * NOTE
 *  factorial (5)
 *  else return 5 * factorial (4)
 *       ~      4 * factorial (3)
 *       ~      3 * factorial (2)
 *       ~      2 * factorial (1)
 *  method factorial (1) -- return 1
 *  then go back: factorial (2) -- return 2 * factorial (2-1) -- 2 * 1
 *                factorial (3) -- return 3 * factorial (2) ---- 3 * 2 * 1
 *                factorial (4) --             ~            ---- 4 * 3 * 2 * 1
 *                factorial (5) --             ~            ---- 5 * 4 * 3 * 2 * 1
 *
 */

import java.util.Scanner;

/**
 * @author Mackenzie
 *
 * Task:
 * asks the user to enter a positive integer n,
 * computes the sum of the first n positive odd integers and prints the sum.
 *
 * For example, if n is 5, you should compute 1 + 3 + 5 + 7 + 9.
 * Don't forget to check whether n is a valid input before using it
 */

public class ComputeOddNumbers {

    public static void main(String[] args) {

        // input prompt

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number : ");

            if (input.hasNextInt()) {
                int num = input.nextInt();

                // initialise
                int odd = 1;
                int sum = 0;

                if (num % 2 != 0 && num > 0) {
                    for (int i = 1; i <= num; i++) {
                        sum = sum + odd;
                        odd = odd + 2;
                    }

                    System.out.println(sum);
                } else {
                    System.out.println("Please enter a positive odd integers!");
                }

            } else {
                System.out.println("Non-numeric input detected. Program exits.");
                break;


            }

        }
    }
}
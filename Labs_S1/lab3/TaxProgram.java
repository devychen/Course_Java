import java.util.Scanner;

/**
 * @author Mackenzie
 *
 * Task:
 * Calculates the tax: >= 100 then 5% tax, less, no tax.
 *
 * ** Example Output
 * Enter the price: 120
 * Item cost: 120.0 Tax: 6.0 Total: 126.0
 * Enter the price: 56
 * Item cost: 56.0 Tax: 0.0 Total: 56.0
 * Enter the price: 114.67
 * Item cost: 114.67 Tax: 5.7335 Total: 120.40350000000001
 */

public class TaxProgram {

    public static void main(String[] args) {

        Scanner priceReader = new Scanner(System.in);

        while (true) { // infinite loop as `true` will never be `false`.
            // input prompt
            System.out.print("Enter the price: ");

            if (priceReader.hasNextDouble()) {
                double price = priceReader.nextDouble();
                double taxRate = 0.0;

                if (price >= 100.00) {
                    taxRate = 0.05;
                } else {
                    taxRate = 0;
                }

                double tax = price * taxRate;
                double total = price + price * taxRate;
                String output = "Item cost: " + price +
                        " Tax: " + tax +
                        " Total: " + total;
                System.out.println(output);

            } else {
                System.out.println("Non-numeric input detected. Program exits.");
                break; // exit
            }
        }
    }
}

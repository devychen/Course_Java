package st3;

/**
 * @author: mkz
 * TASK: create 2 purses and adds coins to them
 *
 * Description: A class to demonstrate the Purse class.
 *                It creates a Purse object and calls the
 *                methods in the Purse class.
 */

public class PurseDemo {
    public static void main(String[] args) {

        // create 2 purses
        Purse p1 = new Purse();
        Purse p2 = new Purse();

        // add coins
        p1.addOneCentCoins(2);
        System.out.println("Expected total: 0.02 euros, actual: " +
                String.format("%.2f", p1.getTotal()) + " euros");
        p1.addTenCentCoins(2);
        System.out.println("Expected total: 0.22 euros, actual: " +
                String.format("%.2f", p1.getTotal()) + " euros");
        p1.addFiftyCentCoins(2);
        System.out.println("Expected total: 1.22 euros, actual: " +
                String.format("%.2f", p1.getTotal()) + " euros");
        p1.addOneEuroCoins(2);
        System.out.println("Expected total: 3.22 euros, actual: " +
                String.format("%.2f", p1.getTotal()));

        // print toString
        System.out.println(p1);

    }
}

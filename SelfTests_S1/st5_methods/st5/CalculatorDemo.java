package st5;

/**
 * @author mkz
 * TASK: A demo for light testing on class Calculator
 */

public class CalculatorDemo {

    public static void main(String[] args) {

        Calculator c = new Calculator();

        // 5+4=9
        c.add(5,4);
        System.out.println("5 + 4 = " + c.getResult());

        // clear, then 6+2=8
        c.clear();
        c.add(6,2);
        System.out.println("6 + 2 = " + c.getResult());

        // clear, then 10+7 = 17
        c.clear();
        c.add(10,7);
        System.out.println("10 + 7 = " + c.getResult());

        // + 3 =  (on previous)
        c.add(3);
        System.out.println("+ 3 = " + c.getResult());

        // * 4 = (on previous)
        c.mul(4);
        System.out.println("* 4 = " + c.getResult());

        // /8 = (on previous)
        c.div(8);
        System.out.println("/8 = " + c.getResult());

        // clear, 3 + 5 =
        c.clear();
        c.add(3,5);
        System.out.println("3 + 5 = " + c.getResult());
    }
}

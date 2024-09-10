package st5;

/**
 * @author: mkz
 *
 * TASK: a calculator that do math operations.
 */

public class Calculator {

    // variables
    private double result;

    /**
     * a default constructor
     */
    public Calculator() {
        result = 0.0;
    }

    /**
     * a constructor that takes one double parameter and sets the result.
     */
    public Calculator(double a){
        result = a;
    }


    /**
     * a method to get the result
     */
    public double getResult() {
        return result;
    }

    /**
     * a method to clear the result
     */
    public void clear(){
        result = 0.0;
    }

    /**
     * 2 methods for each operation (add, subtract, mult, div):
     * One that takes two double parameters and resets result
     * One that takes one double parameter and uses result as one of the operands
     */
    // add
    public void add(double a, double b){
        result = a + b;
    }

    public void add(double a){
        result += a;
    }

    // substract
    public void sub(double a, double b){
        result = a - b;
    }

    public void sub(double a){
        result -= a;
    }

    // multiply
    public void mul(double a, double b){
        result = a * b;
    }

    public void mul(double a){
        result *= a;
    }

    // divide
    public void div(double a, double b){
        result = a / b;
    }

    public void div(double a){
        result /= a;
    }

}

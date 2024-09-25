package examples;


import java.util.Scanner;

/**
 * @author mkz
 * Lecture: Recursion
 * Description: Digit to words.
 *  e.g. 223 - two two three
 */

public class RecursionDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter an integer: ");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        displayAsWords(number);
        System.out.println();

        System.out.println("If you add ten to that number, \n" +
                        "the digits in the new number are");
        number = number + 10;
        displayAsWords(number);
        System.out.println();
    }

    // accepts a single int and produces words representing its digits
    public static void displayAsWords(int number){
        if(number < 10){
            System.out.print(getWordFromDigit(number) + " ");
        } else // number has two or more digits
        {
            displayAsWords(number / 10);                            // note: /10 to get rid of the last
            System.out.print(getWordFromDigit(number % 10) + " "); // note: %10 to get just the last 取余数
        }
    }
    // note 递归本身就实现了“循环”的效果，因此在这种情况下不需要另外编写显性循环语句 such as for, while
    //  The base case is when number is a single digit (number < 10).

    // helper method to get a word for a number < 10
    public static String getWordFromDigit(int number){
        String result = null;
        switch(number){
            case 0: result = "zero"; break;
            case 1: result = "one"; break;
            case 2: result = "two"; break;
            case 3: result = "three"; break;
            case 4: result = "four"; break;
            case 5: result = "five"; break;
            case 6: result = "six"; break;
            case 7: result = "seven"; break;
            case 8: result = "eight"; break;
            case 9: result = "nine"; break; // case后面为用于匹配的值，可数字可字母可单词etc.
            default:
                System.out.println("Fatal Error."); // 如果输入的不是0-9
                System.exit(0);
                break;
        }
        return result;
    }
}

package examples;

/**
 * @author mkz
 * Description: Write a recursive method to reverse the input string
 */

public class ReverseString {

    public static String reverseString(String str) {
        // base case: length is 0 or 1, return itself
        if (str.length() <= 1){
            return str;
        }
        // recursive
        // reverse all but the 1st char, and add char to the end
        return reverseString(str.substring(1)) +
                str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}

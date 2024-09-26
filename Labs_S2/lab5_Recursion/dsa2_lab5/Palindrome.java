package dsa2_lab5;

/**
 * @author mkz
 * Task: complete the two methods to
 *      determine if the string
 */

public class Palindrome {

    /**
     * Recursive method to test if String is a palindrome
     * @param text - the String to test
     * @return True if String is palindrome
     */
    public static boolean isPalindromeRecursive(String text) {
        // todo
        // clean the string
        text = text.toLowerCase();
        text = text.replaceAll(" ", "");
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        // 1. when null, 0 or only 1 char
        if (text == null || text.length() <= 1) {
            return true;
        }
        // 2. length > 1
        // true if head = tail
        if (text.charAt(0) == text.charAt(text.length()-1)){
            return isPalindromeRecursive(
                    // recursively check head vs tail
                    text.substring(1, text.length() -1));
        } else return false;
    }

    /**
     * Iterative method to test if String is a palindrome
     * @param text - the String to test
     * @return True if String is palindrome
     */
    public static boolean isPalindromeIterative(String text) {
        // todo
        text = text.toLowerCase();
        text = text.replaceAll(" ", "");
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        if (text == null || text.length() <= 1) {
            return true;
        }

        // method 1: use for loop
//        for (int i = 0; i < text.length()/2; i++) {
//            if (text.charAt(i) != text.charAt(text.length()-1-i)){
//                return false;
//            };
//        }
//        return true;

        // method 2: use pointers
        int left = 0, right = text.length()-1;
        while (left <= right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            } else {
                // update pointers
                left ++;
                right --;
            }
        }
        return true;
    }
}

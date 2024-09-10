package st8;

/**
 * @author mkz
 *
 * TASK: implements helper methods for arrays based on javadoc.
 *      This class contains various methods for manipulating arrays.
 *      @author Saile
 */

public class STArrays {

    /**
     * Constructor
     */
    public STArrays(){

    }

    /**
     * Returns a string representation of the contents of the specified array.
     *      The string representation consists of a list of the array's elements,
     *      enclosed in square brackets ("[]").
     *      Adjacent elements are separated by the characters ", "
     *      (a comma followed by a space).
     * @param anIntArray Array whose string representation to return.
     * @return a string representation of the contents of the specified array.
     */
    public static String toString(int[] anIntArray){

        String result = "[";
        for (int i = 0; i < anIntArray.length; i++) {
            result += anIntArray[i];
            if (i < anIntArray.length - 1) { // 确保结尾单词没有","
                result += ", ";
            }
        }
        result += "]";

        return result;
    }


    /**
     * Copies the specified range of the specified array
     *      into a new array and returns the new array.
     * @param anIntArray the array from which a slice is to be copied.
     * @param start the initial index of the range to be copied, inclusive.
     * @param end the final index of the range to be copied, exclusive.
     *            (This index may lie outside the array.)
     * @return an array with the specified range of the specified array
     *         or
     *          null when: anIntArray == null
     *         or
     *          start < 0 || end > anIntArray.length || start > anIntArray.length
     *         or
     *          end < start
     *         or
     *          start > end
     */
    public static int[] slice(int[] anIntArray, int start, int end) {

        if (anIntArray == null){
            return null;
        }

        if (end < start){
            return null;
        }

        if (start < 0 || end > anIntArray.length ||
                start > anIntArray.length) {
            return null;
        }

        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i-start] = anIntArray[i];
        }
        return result;
    }



}

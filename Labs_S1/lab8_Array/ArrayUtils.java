/**
 * @author: mkz
 * Task: create a class to implements all the helper methods for arrays,
 *      based on the documentation in folder /doc
 */

public class ArrayUtils {

    /**
     * Defaut constructor.
     */
    public ArrayUtils() {
    }


    /**
     * Returns a new array with the reversed members of anArray
     * @param anArray The array to reverse
     * @return An array with the reversed members of anArray
     */
    public static Object[] reverseArray(Object[] anArray){

        // null case
        if(anArray == null){
            return null;
        }

        Object[] result = new Object[anArray.length];

        if(anArray != null){
            for(int i = 0; i < anArray.length; i++){
                result[i] = anArray[anArray.length - (i + 1)];
            }
        }
        return result;
    }
    // 编译器要求 Java 方法必须在所有路径上都能够返回值
    /**
     * if (anArray != null) {
     *     Object[] result = new Object[anArray.length];
     *     for (int i = 0; i < anArray.length; i++) {
     *         result[i] = anArray[anArray.length - (i + 1)];
     *     }
     *     return result;
     * }
     * return null;
     * ----这两种也可以----
     * if (anArray == null) {
     *     return null;
     * } else {
     *     Object[] result = new Object[anArray.length];
     *     for (int i = 0; i < anArray.length; i++) {
     *         result[i] = anArray[anArray.length - (i + 1)];
     *     }
     *     return result;
     *     //在 if-else 结构中，如果所有的逻辑分支都能保证有一个 return 语句，
     *     //  那么编译器就不会要求在 if-else 块之外再加一个 return 语句。
     *     //  而在没有 else 的情况下，如果你在 if 块内返回值，而 if 块外没有明确的返回值，
     *     //  编译器会要求你在 if 块之外提供一个 return 语句。
     * }
     */

    /**
     * Returns an array with the concatenation of array1 and array2
     * @param array1 first array
     * @param array2 second array
     * @return The concatenation of array1 and array2
     */
    public static Object[] concatArrays(Object[] array1, Object[] array2){

        // null case
        if (array1 == null && array2 == null){
            return null;
        }

        if (array1 == null && array2 != null){
            return array2;
        }

        if (array1 != null && array2 == null){
            return array1;
        }

        // new list object created
        // length, conditional operator, `result = condition ? value_if_true : value_if_false;`
//        int len = (array1 != null ? array1.length : 0) + (array2 != null ? array2.length : 0);
        Object[] result = new Object[array1.length + array2.length];

        if (array1 != null && array2 != null){

            // copy array1
            for (int i = 0; i < array1.length; i++){
                result[i] = array1[i];
            }
            // copy array2
            for (int i = 0; i < array2.length; i++){
                result[i + array1.length] = array2[i];
            }
        }
        return result;
    }

    /**
     * Returns the index of the (first) occurrence of object aObject in array anArray
     *    or -1 when aObject is not contained in anArray
     * @param anArray Haystack
     * @param aObject Needle
     * @return Index in anArray or -1 when not found.
     */
    public static int searchArrayForAnObject(Object[] anArray, Object aObject){

        int index = -1;
        if(anArray == null){
            index = -1;
        }

        if(anArray != null) {
            for (int i = 0; i < anArray.length; i++) {
                if (anArray[i] == aObject) {
                    index = i;
                }
            }
        }
        return index;
    }

}

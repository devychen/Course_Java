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

        if(anArray != null && anArray.length > 0){
            for(int i = 0; i < anArray.length; i++){
                result[i] = anArray[anArray.length - (i + 1)];
            }
        }
        return result;
    }

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
        int len = (array1 != null ? array1.length : 0) + (array2 != null ? array2.length : 0);
        Object[] result = new Object[len];

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
        for(int i = 0; i < anArray.length; i++){
            if(anArray[i] == aObject){
                index = i;
            }
        }
        return index;
    }

}

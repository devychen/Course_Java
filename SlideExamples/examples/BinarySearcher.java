package examples;

/**
 * @author mkz
 * Description: a recursive method that determines if
 *      a given number is in a sorted array of ints.
 *      If the number is in the array, return the index of the number in the array.
 *      If the number is not in the array, return -1
 *      e.g. Looking up a number in a phone book
 */

public class BinarySearcher {
    // Base case: If our number is at index mid we are done
    // Recursive case: If our number is smaller than the number at index mid, search the frst half (from first to mid-1).
    // Recursive case: If our number is greater than the number at index mid, search the secondhalf (frommid+1tolast).

    private int[] a;

    /**
     * Default constructor
     *
     * @param theArray
     */
    public BinarySearcher(int[] theArray) {
        a = theArray;
    }

    /**
     * If the target is in the array,
     * returns the index of an occurrence of target,
     * otherwise -1
     *
     * @param target
     * @return the index, or - 1 if not found.
     */
    public int find(int target) {
        return binarySearch(target, 0, a.length - 1); // search with the first (0) and last (a.length-1) index of the array.
    }

    /**
     * Use binary search to search for target,
     * in a[first] through a[last] inclusive
     * returns the index of target if found,
     * returns -1 if not found.
     *
     * @param target target number to be found
     * @param first
     * @param last
     * @return
     */
    public int binarySearch(int target, int first, int last) {
        int result;
        if (first > last) {
            result = -1;
        } else { // else means first <= last
            int mid = (first + last) / 2;
            if (target == a[mid]) {
                result = mid;
            } else if (target < a[mid]) {
                result = binarySearch(target, first, mid - 1);
            } else { // (target > a[mid]) {
                result = binarySearch(target, mid + 1, last);
            }
        }
        return result;
    }
}
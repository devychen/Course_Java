/**
 * @author mkz
 *
 * Task: add 3 new methods (others remain unchanged)
 *  public void insertAt(int index, String item)
 *    Insert String item at position index.
 *  public boolean remove(String item)
 *    Remove String item from the list. Returns true when item was successfully removed and false otherwise.
 *  public String[] toArray()
 *    Returns the content as an array of Strings. (Copy every non-null element in list into an array)
 *
 * EXAMPLE:
 *  *
 *  * String[] expected = {"AA","BB","CC"};
 *  * String[] res = testList.toArray();
 *  * assertTrue(expected.length == res.length);
 *  * for (int i=0;i<res.length;i++)  {
 *  * assertEquals(res[i],expected[i]);
 *  * }
 */

public class StringList {

    private static final int INITIAL_SIZE = 3;    // initial size if none is given in constructor
    private int numElements;           // number of elements currently in list
    protected static String[] list;         // array instance variable

    public StringList() {
        numElements = 0;
        list = new String[INITIAL_SIZE];
    }

    public StringList(int initialSize) {
        numElements = 0;
        list = new String[initialSize];
    }

    public void add(String item) {
        // transfer list to a larger array when full
        if (numElements == list.length) {
            // 当前数组元素数是否等于数组长度，等于则已满需扩容
            String[] tmp = new String[numElements + INITIAL_SIZE];

            for (int i = 0; i < numElements; i++) {
                tmp[i] = list[i];
            }

            list = tmp;
        }

        // add item
        list[numElements] = item;
        numElements++;
    }

    public boolean contains(String item) {
        boolean found = false; //初始化名为found的boolean variable为false，表示尚未找到

        for (int i = 0; (i < numElements) && !found; i++) {
            //WHY: !found 表示 found 为 false，即目标字符串尚未找到 循环继续执行
            if (list[i].equalsIgnoreCase(item))
            {
                found = true;
            }
        }

        return found;
    }

    public String get(int index) {
        String result = null;

        if ((index >= 0) && (index < numElements)) {
            result = list[index];
        }

        return result;
    }

    // TODO: add three new methods:

    /*
    insert String `item` at position `index`
     */
    public void insertAt(int index, String item){

        // handle exception
        if ((index < 0) || (index > numElements)) {
            throw new IndexOutOfBoundsException();
        }

        // create new list to store results
        String[] result = new String[numElements + 1];

        // Elements before index stays where they are
        for (int i = 0; i < index; i++) {
            result[i] = list[i];
        }

        // elements after index move one position to right
        for (int j = index; j < numElements; j++) {
            result[j + 1] = list[j];
        }

        // insert new item at index
        result[index] = item;

        list = result;
        numElements++;
    }


    /*
    Remove String `item` from the list.
    Returns true when item was successfully removed and false otherwise.
     */
    public boolean remove(String item){

        boolean found = false;
        int index = -1;

        // loop to find the element
        for (int i = 0; i < numElements; i++) {
            if (list[i].equalsIgnoreCase(item)) {
                index = i;
                break;
            }
        }

        if (found){
            // new list to store result
            String[] result = new String[numElements - 1];

            // left to index, remains the same
            for (int j = 0; j < index; j++) {
                result[j] = list[j];
            }

            // right to index, move one position to the left
            for (int j = index + 1; j < numElements; j++) {
                result[j - 1] = list[j];
            }

            list = result;

            numElements--;

            found = true;
        }
        return found;
    }

    /*
    Returns the content as an array of Strings.
    (Copy every non-null element in list into an array)
     */
    public String[] toArray(){

        String[] result = new String[numElements];

        for (int i = 0; i < numElements; i++){
            if(list[i] != null){
                result[i] = list[i];
            }
        }

        return result;
    }

    /**
     * Return the content as a String representation without null elements.
     */
    public String toString(){

        String result = "[";

        for (int i = 0; i < numElements; i++) {
            result += list[i] + ", ";
        }

        result = result.substring(0, result.length() - 2);
        result += "]";

        return result;
    }

}
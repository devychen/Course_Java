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

        if (index >= 0 && index < numElements) {
            // update size
            // 如果现在元素数已经等于长度，那加一个元素必然会溢出
            if (numElements == list.length) {
                String[] tmp = new String[numElements + INITIAL_SIZE];

                for (int i = 0; i < numElements; i++) {
                    tmp[i] = list[i];
                }
                list = tmp;
            }

            // shift list elements to make room for the new item
            // start from the last element
            for (int i = numElements; i > index; i--) {
                list[i] = list[i - 1];
            }

            list[index] = item;
            numElements++;
        } else {
            System.out.println("Index out of bounds.");
        }

    }

    /*
    Remove String `item` from the list.
    Returns true when item was successfully removed and false otherwise.
     */
    public boolean remove(String item){

        // Remove String item from the list.
        // Returns true when item was successfully removed and false otherwise.
        int index = -1;
        for (int i = 0; i < numElements; i++){
            if (list[i].equalsIgnoreCase(item)){
                index = 1;
                break;
            }
        }
        if (index != -1){
            // shift elements to fill the gap left by the removed item
            for (int i = index; i < numElements - 1; i++){
                list[i] = list[i + 1];
            }
            // set the last element to null and decrement the count
            list[numElements - 1] = null;
            numElements--;
            return true;
        }
        return false;
    }

    /*
    Returns the content as an array of Strings.
    (Copy every non-null element in list into an array)
     */
    public String[] toArray(){
        // Returns the content as an array of Strings.
        // (Copy every non-null element in list into an array)
        String[] result = new String[numElements];
        for (int i = 0; i < numElements; i++) {
            result[i] = list[i];
        }
        return result;
    }

}
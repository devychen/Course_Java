package dsa2_st2;

/**
 * Description: A class to store and manipulate generic circularly linked lists
 *
 * @author mkz
 * TASK: Complete the missing methods
 */

public class CircularlyLinkedList<T> {
    
    private ListNode cur;
    private ListNode prev;
    private int size; 
    
    /**
     *  Default constructor.  Creates an empty list
     */
    public CircularlyLinkedList() {
        // todo
        cur = null;
        prev = null;
        size = 0;
    }
    
    /**
     * Get the size of the list.
     * @return the number of elements in this list.
     */
    public int size() {
        return size;
    }
    
    /**
     *  Removes all of the elements from this list.
     */
    public void clear() {
        // todo
        cur = prev = null;
        size = 0;
        /*
        NOTE: 将 cur 和 prev 都设置为 null，实际上就是把链表的引用断开了。
         原来的节点没有任何引用指向它们，这些节点会被垃圾回收机制回收
         （因为 Java 的垃圾回收机制会自动清理没有被引用的对象）。
         这就意味着链表不再引用任何节点，等同于把整个链表清空。
         */
    }
    
    /**
     *  Add an element after current. After this call, current
     *  is the element added.
     *  @param newData the data to add
     */
    public void add(T newData) {
        
       // todo
        ListNode newNode = new ListNode(newData, null);

        if (cur == null) {  // add first element to the list
            cur = newNode;
            cur.link = cur; // NOTE ???
            prev = cur;
        } else {           // add element after current to existing list
            // move pointers
            newNode.link = cur.link;
            cur.link = newNode;
            // update nodes
            prev = cur;
            cur = newNode;
        }
        
        // increment size of the list
        size ++;

    }
    
    /**
     *  Get the data at the current node in this list.
     *  @return data at current.
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T getCurrent() throws CircularlyLinkedListException {
        
        // todo
        // empty list
        if (cur == null) {
            throw new CircularlyLinkedListException
                    ("Attempting to get element from an empty list.");
        }

        return cur.data;
    }
    
    /**
     *  Advance n positions in this list.  After this call, 
     *  current is n positions farther along the list.
     *  @param n the number of positions to advance
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public void advance(int n) throws CircularlyLinkedListException {
        
        // todo
        // invalid n
        if (n <= 0 || n == size){
            throw new CircularlyLinkedListException("Invalid n");
        }

        // empty list
        if (cur == null) {
            throw new CircularlyLinkedListException
                    ("Attempting to advance in an empty list.");
        } else {
            // not empty, iterate repeatedly
            for (int i = 0; i < n; i++) {
                prev = cur;
                cur = cur.link;
            }
        }


    }
    
    /**
     *  Advance to element in this list, testing for equality
     *  using the `equals` method.
     *  After this call, the node containing element is current.
     *  @param element the element to advance to
     *  @throws CircularlyLinkedListException if the element is not in the list.
     */
    public void advance(T element) throws CircularlyLinkedListException {
        
        // todo
        // empty list
        if (cur == null) {
            throw new CircularlyLinkedListException("Attempting to advance in an empty list.");
        } else {
            // not empty, compare and update, and advance
            for (int i = 0; i < size; i++) {
                if (cur.data.equals(element)) {
                    return;
                } else {
                    prev = cur;
                    cur = cur.link;
                }
            }
            // throw exception if not found eventually
            throw new CircularlyLinkedListException
                    ("Element not found.");
        }

    }
    
    /**
     *  Remove the current node in this list and return the element removed.
     *  After this call, current is the element after the removed element.
     *  @return the deleted element
     *  @throws CircularlyLinkedListException if the list is empty
     */
    public T remove() throws CircularlyLinkedListException {

        T element = null;

        // todo
        // remove from empty list
        if (cur == null) {
            throw new CircularlyLinkedListException
                    ("Attempting to remove from an empty list.");
        }
        // remove one-node list
        if (size == 1){
            element = cur.data;
            cur = null;
            prev = null;
        } else {
            // more than one element
            element = cur.data;
            cur = cur.link;
            prev.link = cur;
        }
        // decrement size
        size --;

        return element;

    }
    
    /**
     *  Get a string representation of this list, starting at
     *  the current element.
     *  @return a string representation of this list.
     */
    public String toString() {
        
        String rval = "";
        ListNode position = cur;
        
        for (int i=0; i<size; i++) {
            rval += position.data + " ";
            position = position.link;
        }
        
        return rval;
    }
    
    private class ListNode {
        private T data;
        private ListNode link;
        
        public ListNode() {
            data = null;
            link = null;
        }
        public ListNode(T newData) {
            data = newData;
            link = null;
        }
        public ListNode(T newData, ListNode aLink) {
            data = newData;
            link = aLink;
        }
    }
}

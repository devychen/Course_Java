package dsa2_lab2;

/**
 *
 * This class is a linked list implementation of the SimpleList interface.
 *
 * @author mkz
 * TASK: finish the class, starter codes are given.
 *
 */

import java.util.*;

public class SLinkedList<T> implements SimpleList<T> {

	// Variables
	private ListNode head;
	private int numberOfElements;

	// TODO Constructor
	public SLinkedList() {
		head = null;
		numberOfElements = 0;
	}

	// Methods
	/**
	* Appends the specified element to the end of this list
	* @param element element to add to the list
	* @return true when add operation is successful // Note 判断元素是否成功添加
	* @throws NullPointerException when element is null
	*/
	public boolean add(T element) {

		// if null element is tba
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		// if list is empty, this becomes the only element, and it's the end so `link null`
		if (head == null) {
			head = new ListNode(element, null);
		} else {
			// otherwise, add to the end
			ListNode current = head; // start from the head
			while (current.next != null) { // NOTE: loop, move to the next, the end would be when `current.next == null`
				current = current.next;
			}
			current.next = new ListNode(element, null);
			// NOTE: vs array是基于index（索引），所以通常需要知道长度才能通过index访问最后一个位置
		}
		numberOfElements++; // update list length
		return true;
	}

	/**
	* Returns the element at the specified position in this list.
	* @param index retrieve position
	* @throws IndexOutOfBoundsException when index is out of bounds (index < 0 || index >= size())
	*/
	public T get(int index) {

		if (index < 0 || index >= numberOfElements) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numberOfElements);
		}
		ListNode current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	* Returns the index in this list of the first occurrence of the specified element,
	* or -1 if this list does not contain this element.
	* @param o Object to search in list
	* @return position of o or -1 if not found
	* @throws NullPointerException when o is null
	*/
	public int indexOf(Object o) {

		if (o == null) {
			throw new NullPointerException("Object cannot be null");
		}
		ListNode current = head;
		int index = 0;
		while (current != null){
			if(current.data.equals(o)){
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	/**
	* Returns true if this list contains no elements.
	* @return true if list contains no elements, false otherwise
	*/
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	/**
	* Removes the element at the specified position from this list.
	* @return element.
	* @throws IndexOutOfBoundsException when index is out of bounds (index < 0 || index >= size())
	*/
	public T remove(int index) {
		if (index < 0 || index >= numberOfElements) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numberOfElements);
		}
		T element;
		// if what to be removed is the head
		if (index == 0){
			element = head.data; // element is the head
			head = head.next; // update head to be next node, so removed
		} else {
			ListNode current = head;
			ListNode previous = null;
			for (int i = 0; i < index; i++){
				previous = current;
				current = current.next;
			}
			element = current.data;
			previous.next = current.next;
		}
		numberOfElements--;
		return element;
	}

	/**
	* Returns the number of elements in this list.
	* @return number of elements in this list
	*/
	public int size() {
		return numberOfElements;
	}

	/**
	* Return a String representing the SLinkedList<T> The result String consists of a '['
	* then the elements of the list separated by a comma and then a ']' character. A list
	* with the elements "Hello" and "World" should return a String "[Hello,World]"
	* @return String representing the list
	*/
	public String toString() {
		if (isEmpty()){
			return "[]\n";
		}
		String res = "[";
		ListNode current = head;
		while (current != null) {
			res += current.data;
			if (current.next != null){ // NOTE: only add comma when not the last element
				res += ",";
			}
			current = current.next;
		}
		res += "]";
		return res;
	}

	// this is bonus exercise 1/2

	/**
	 * The method iterator() should return an object Iterator.
	 * 	This object is used to provide
	 * 	sequential access to the elements in a collection.
	 * @return
	 */
	public Iterator<T> iterator()
	{
		return new LinkedListIterator();
	}


	/**
	* This class implements a node in a linked list data structure
	*/
	private class ListNode {
		private T data;
		private ListNode next;

		public ListNode()  {
			data = null;
			next = null;
		}

		public ListNode(T element, ListNode link)  {
			data = element;
			next = link;
		}
	}

	// this is bonus exercise 2/2
	// NOTE: iterator<E> documentation:
	//  https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	//  思路：add a reference variable to keep track of current position in the list
	//     --- then the constructor initialise this current node from head
	//     --- then implement the two methods
	private class LinkedListIterator implements Iterator<T>
	{
		//add variable
		ListNode current;

		//constructor

		/**
		 * Performs the given action for each remaining element until
		 * 	all elements have been processed or the action throws an exception.
		 */
		public LinkedListIterator(){
			current = head;
		}

		//methods

		/**
		 * Returns true if the iteration has more elements.
		 * @return
		 */
		public boolean hasNext(){
			return current != null;
		}

		/**
		 * Returns the next element in the iteration.
		 * @return
		 */
		public T next(){
			if (!hasNext()){
				throw new NoSuchElementException("No more elements to iterate");
			}
			T data = current.data; // get current data
			current = current.next; // pointer move to next
			return data;
		}

	}
}

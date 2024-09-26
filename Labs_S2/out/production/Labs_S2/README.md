# Lab 2

## Exercise 1

Write a linked list class `SLinkedList.java` which implements the `SimpleList` interface. The `SimpleList` interface is a simple subset of the [Sun Microsystems](http://docs.oracle.com/javase/6/docs/api/java/util/List.html) `List` interface. Please read the documentation **carefully** before you start writing your own list class. You can access the documentation by cloning this repository and opening `doc/SimpleList.html` locally on your computer. In addition to the methods required by the interface, your class needs a simple default constructor that creates an empty list.

**Important: Since the whole point of this exercise is to build an own list you are obviously not allowed to use any built in lists of Java. Instead you have to work with ListNode**


### Files you need:

You can find the definition for the `SimpleList` interface in `src/SimpleList.java`. The `src` folder contains starter code for you to work on.

### Demo
You can use `SLLDemo.java` to make sure that your class does what we expect it to do. Feel free to write your own JUnit tests, but you do not need to push them to the remote repository. They will not be graded.

## Bonus Question: Iterators
If you have time left, you can complete the inner class `LinkedListIterator` that is called in the method `iterator()`. **The method `iterator()` should return an object `Iterator`. This object is used to provide sequential access to the elements in a collection.**

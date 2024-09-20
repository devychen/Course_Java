package dsa2_st2;

public class CircularlyLinkedListException extends Exception {
    public CircularlyLinkedListException() {
        super("Error operating on CircularLinkedList.");
    }

    public CircularlyLinkedListException(String message) {
        super(message);
    }
}

package st10;

/**
 * @author mkz
 * TASK:
 */

public class PurseException extends Exception {

    public PurseException() {
        super("Purse Error");
    }

    public PurseException(String message) {
        super(message);
    }
}

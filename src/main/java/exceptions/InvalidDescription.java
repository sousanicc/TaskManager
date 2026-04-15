package exceptions;

public class InvalidDescription extends RuntimeException {
    public InvalidDescription(String message) {
        super(message);
    }
}

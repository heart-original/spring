package spring.exception;

public class NotEnoughException extends RuntimeException {
    public NotEnoughException() {
    }

    public NotEnoughException(String message) {
        super(message);
    }
}

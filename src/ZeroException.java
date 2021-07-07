

public class ZeroException extends Exception {
    public ZeroException(String message) {
        super(message);
    }

    public ZeroException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
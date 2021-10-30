package by.skarulskaya.exception;

public class PyramidCustomException extends Exception {
    public PyramidCustomException() {
        super();
    }

    public PyramidCustomException(String message) {
        super(message);
    }

    public PyramidCustomException(String message, Exception e) {
        super(message, e);
    }

    public PyramidCustomException(Exception e) {
        super(e);
    }
}

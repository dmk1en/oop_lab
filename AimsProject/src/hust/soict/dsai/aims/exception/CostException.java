package hust.soict.dsai.aims.exception;

public class CostException extends Exception {
    public CostException(String message) {
        super();
        System.err.println(message);
    }
}


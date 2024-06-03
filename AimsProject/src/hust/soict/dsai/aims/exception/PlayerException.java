package hust.soict.dsai.aims.exception;


public class PlayerException extends Exception{

    public PlayerException(String message) {
        super();
        System.err.println(message);
    }
}
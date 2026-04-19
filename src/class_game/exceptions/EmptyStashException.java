package class_game.exceptions;

public class EmptyStashException extends RuntimeException {
    public EmptyStashException(String message) {
        super(message);
    }
}
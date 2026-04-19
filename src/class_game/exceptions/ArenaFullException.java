package class_game.exceptions;

public class ArenaFullException extends RuntimeException {
    public ArenaFullException(String message) {
        super(message);
    }
}
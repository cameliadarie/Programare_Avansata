package lab5hw.commands;

public class InvalidCommandException extends Throwable {
    public InvalidCommandException(String message) {
        super(message);
    }
}

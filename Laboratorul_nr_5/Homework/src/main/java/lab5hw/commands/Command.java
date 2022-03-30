package lab5hw.commands;

import java.io.IOException;

/**
 * This interface represents a command,
 * I will use this to create my specific commands
 */
public interface Command {
    void executeCommand() throws IOException, ClassNotFoundException, InvalidCommandException;
}
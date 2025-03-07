package caifan.commands;

/**
 * Represents a command to exit the application.
 * This command triggers the shutdown of the program.
 */
public class ExitCommand extends Command {

    /**
     * Represents a command to exit the application.
     * This command triggers the shutdown of the program.
     */
    public ExitCommand(String command) {
        super(command);
    }

    /**
     * Executes the exit command.
     * No specific action needed as the main loop checks isExit().
     */
    public void execute () {}

    /**
     * Indicates that this command should terminate the program.
     *
     * @return true to signal that the program should exit
     */
    public boolean isExit() {
        return true;
    }
}

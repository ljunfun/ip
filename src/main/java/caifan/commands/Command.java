package caifan.commands;

import caifan.TaskList;

/**
 * Abstract base class for all commands.
 */
public abstract class Command {
    String command;

    /**
     * Creates a new command with the given input string.
     * @param command The original command string
     */
    Command(String command) {
        this.command = command;
    }

    /**
     * Executes the command according to which command class is called
     */
    public abstract void execute();

    public boolean isExit() {
        return false;
    }

}

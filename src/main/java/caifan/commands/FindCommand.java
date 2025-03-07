package caifan.commands;

import caifan.TaskList;

/**
 * Command to find tasks matching a keyword.
 */
public class FindCommand extends Command {

    /**
     * Creates a new find command.
     * @param command The original command string
     */
    public FindCommand(String command) {
        super(command);
    }

    /**
     * Executes the find command to search for tasks.
     */
    @Override
    public void execute() {
        TaskList.handleFind(command);
    }
}

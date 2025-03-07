package caifan.commands;

import caifan.TaskList;

/**
 * Represents a command to mark a task as not completed.
 * This command reverses the completion status of the specified task.
 */
public class UnmarkCommand extends Command {

    /**
     * Creates a new unmark command.
     *
     * @param command The original command string containing the index to unmark
     */
    public UnmarkCommand(String command) {
        super(command);
    }

    /**
     * Executes the unmark command by marking the specified task as not completed.
     * The task list will be updated and changes will be persisted.
     */
    @Override
    public void execute() {
        TaskList.handleUnmark(command);
    }
}

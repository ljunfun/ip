package caifan.commands;

import caifan.TaskList;

/**
 * Executes the delete command by removing the specified task from the list.
 * The task list will be updated and changes will be persisted.
 */
public class MarkCommand extends Command {

    /**
     * Creates a new done command.
     *
     * @param command The original command string containing the index to mark as done
     */
    public MarkCommand(String command) {
        super(command);
    }

    /**
     * Executes the done command by marking the specified task as completed.
     * The task list will be updated and changes will be persisted.
     */
    @Override
    public void execute() {
        TaskList.handleMark(command);
    }
}

package caifan.commands;

import caifan.TaskList;
import caifan.tasks.Task;

/**
 * Represents a command to delete a task from the task list.
 * This command removes the specified task based on its index.
 */
public class DeleteCommand extends Command{

    /**
     * Creates a new delete command.
     *
     * @param command The original command string containing the index to delete
     */
    public DeleteCommand(String command) {
        super(command);
    }

    /**
     * Executes the delete command by removing the specified task from the list.
     * The task list will be updated and changes will be persisted.
     */
    @Override
    public void execute() {
        TaskList.deleteTask(command);
    }
}

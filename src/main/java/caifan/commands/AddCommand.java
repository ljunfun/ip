package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.tasks.Task;

/**
 * Represents a command to add a new task to the task list.
 * This command handles the creation and addition of all task types (Todo, Deadline, Event).
 */
public class AddCommand extends Command{
    private static Task task;

    /**
     * Creates a new add command with the specified command string and task.
     *
     * @param command The original command string from user input
     * @param task The task object to be added to the task list
     */
    public AddCommand(String command, Task task) {
        super(command);
        this.task = task;
    }

    /**
     * Executes the add command by adding the task to the task list.
     * The task list will be updated and the task will be persisted.
     */
    @Override
    public void execute() {
        TaskList.addTask(task);
    }
}

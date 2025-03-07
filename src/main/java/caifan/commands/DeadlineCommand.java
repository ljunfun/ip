package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.tasks.Deadline;

import static caifan.TaskList.DESCRIPTION_INDEX;

/**
 * Returns a string representation of the todo task.
 * Includes the task type, completion status, and description.
 *
 * @return The formatted string representation of the todo task
 */
public class DeadlineCommand extends Command {

    /**
     * Creates a new deadline command with the specified task.
     *
     * @param command The original command string from user input
     */
    public DeadlineCommand(String command) {
        super(command);
    }

    /**
     * Executes the deadline command by adding the deadline task to the task list.
     * The task list will be updated and the task will be persisted.
     */
    @Override
    public void execute() {
        try {
            String description = command.substring(command.indexOf(" ") + DESCRIPTION_INDEX);
            String[] parts = description.split(" /by ");
            String splitDescription = parts[0];
            String deadline = parts[1];
            TaskList.addTask(new Deadline(splitDescription, deadline));
        } catch (IndexOutOfBoundsException e) {
            Ui.printLine();
            Ui.println("\tWhy is your description/deadline empty?!! Put something there >_<");
            Ui.println("\tPlease input a valid deadline or description, HMPH :<");
            Ui.printLine();
        }
    }
}

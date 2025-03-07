package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.exceptions.InvalidDescriptionException;
import caifan.tasks.Todo;

import static caifan.TaskList.DESCRIPTION_INDEX;


/**
 * Represents a command to create and add a new todo task.
 * This command handles parsing todo task details and adding them to the task list.
 */
public class TodoCommand extends Command {

    /**
     * Creates a new todo command with the specified task.
     *
     * @param command The original command string from user input
     */
    public TodoCommand(String command) {
        super(command);
    }

    /**
     * Executes the todo command by adding the todo task to the task list.
     * The task list will be updated and the task will be persisted.
     */
    @Override
    public void execute() {
        try {
            String description = command.substring(command.indexOf(" ") + DESCRIPTION_INDEX);
            if (description.isBlank() || !command.contains(" ")) {
                throw new InvalidDescriptionException();
            }
            TaskList.addTask(new Todo(description));
        } catch (InvalidDescriptionException e) {
            Ui.printLine();
            Ui.println("\tWhy is your description empty?!! Put something there >_<");
            Ui.printLine();
        }
    }
}

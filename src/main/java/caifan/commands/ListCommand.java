package caifan.commands;

import caifan.Ui;

/**
 * Represents a command to display all tasks in the task list.
 * This command shows the complete list of tasks with their current status.
 */
public class ListCommand extends Command {

    /**
     * Creates a new list command.
     *
     * @param command The original command string from user input
     */
    public ListCommand(String command) {
        super(command);
    }

    /**
     * Executes the list command by displaying all tasks in the task list.
     */
    @Override
    public void execute() {
        Ui.printList();
    }
}

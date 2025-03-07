package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.tasks.Event;

import static caifan.TaskList.DESCRIPTION_INDEX;

/**
 * Executes the deadline command by adding the deadline task to the task list.
 * The task list will be updated and the task will be persisted.
 */
public class EventCommand extends Command{

    /**
     * Creates a new event command with the specified task.
     *
     * @param command The original command string from user input
     */
    public EventCommand(String command) {
        super(command);
    }

    /**
     * Executes the event command by adding the event task to the task list.
     * The task list will be updated and the task will be persisted.
     */
    @Override
    public void execute() {
        try {
            String description = command.substring(command.indexOf(" ") + DESCRIPTION_INDEX);
            String[] parts = description.split(" /from | /to ");
            String splitDescription = parts[0];
            String start = parts[1];
            String end = parts[2];

            TaskList.addTask(new Event(splitDescription, start, end));

        } catch (IndexOutOfBoundsException e) {
            Ui.printLine();
            Ui.println("\tWhy is your description or start/end dates empty?!! Put something there >_<");
            Ui.println("\tPlease input a valid event or start/end dates, HMPH :<");
            Ui.printLine();
        }
    }
}

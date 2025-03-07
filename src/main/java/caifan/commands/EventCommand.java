package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.tasks.Event;

import static caifan.TaskList.DESCRIPTION_INDEX;

public class EventCommand extends Command{

    public EventCommand(String command) {
        super(command);
    }

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

package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.exceptions.InvalidDescriptionException;
import caifan.tasks.Todo;

import static caifan.TaskList.DESCRIPTION_INDEX;

public class TodoCommand extends Command {

    public TodoCommand(String command) {
        super(command);
    }

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

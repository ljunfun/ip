package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.tasks.Deadline;

import static caifan.TaskList.DESCRIPTION_INDEX;

public class DeadlineCommand extends Command {

    public DeadlineCommand(String command) {
        super(command);
    }


    @Override
    public void execute() {
        try {
            //obtain the description and the deadline
            String description = command.substring(command.indexOf(" ") + DESCRIPTION_INDEX);

            //split the string according to the word that separates the description and the deadline
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

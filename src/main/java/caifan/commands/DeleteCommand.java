package caifan.commands;

import caifan.TaskList;
import caifan.tasks.Task;

public class DeleteCommand extends Command{

    public DeleteCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        TaskList.deleteTask(command);
    }
}

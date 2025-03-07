package caifan.commands;

import caifan.TaskList;
import caifan.Ui;
import caifan.tasks.Task;

public class AddCommand extends Command{
    private static Task task;

    public AddCommand(String command, Task task) {
        super(command);
        this.task = task;
    }

    @Override
    public void execute() {
        TaskList.addTask(task);
    }
}

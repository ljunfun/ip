package caifan.commands;

import caifan.TaskList;

public class UnmarkCommand extends Command {

    public UnmarkCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        TaskList.handleUnmark(command);
    }
}

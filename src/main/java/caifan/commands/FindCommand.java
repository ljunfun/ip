package caifan.commands;

import caifan.TaskList;

public class FindCommand extends Command {
    public FindCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        TaskList.handleFind(command);
    }
}

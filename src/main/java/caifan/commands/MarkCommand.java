package caifan.commands;

import caifan.TaskList;

public class MarkCommand extends Command {
    private static String input;

    public MarkCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        TaskList.handleMark(command);
    }
}

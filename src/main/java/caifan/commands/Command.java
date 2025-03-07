package caifan.commands;

import caifan.TaskList;

public abstract class Command {
    String command;

    Command(String command) {
        this.command = command;
    }

    public abstract void execute();

    public boolean isExit() {
        return false;
    }

}

package caifan.commands;

import caifan.Ui;

public class ListCommand extends Command {
    public ListCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        Ui.printList();
    }
}

package caifan.commands;

public class ByeCommand extends Command {
    public ByeCommand(String command) {
        super(command);
    }

    public void execute () {}

    public boolean isExit() {
        return true;
    }
}

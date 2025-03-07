package caifan;

import caifan.commands.*;
import caifan.exceptions.InvalidDescriptionException;

public class Parser {

    private static TaskList taskList;



    //main logic that processes the commands as they are sifted with the input
    public static Command parseCommand(String input) throws InvalidDescriptionException {

        String stringParts[] = input.split(" ", 2);
        String command = stringParts[0];

        switch (command.toLowerCase()) {
        case "bye":
            Storage.saveFile(taskList);
            return new ByeCommand(input);
        case "list":
            return new ListCommand(input);
        case "mark":
            return new MarkCommand(input);
        case "unmark":
            return new UnmarkCommand(input);
        case "todo":
            return new TodoCommand(input);
        case "deadline":
            return new DeadlineCommand(input);
        case "event":
            return new EventCommand(input);
        case "delete":
            return new DeleteCommand(input);
        default:
            throw new InvalidDescriptionException();
        }
    }
}

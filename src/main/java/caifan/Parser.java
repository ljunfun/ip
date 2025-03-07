package caifan;

import caifan.commands.*;
import caifan.exceptions.InvalidDescriptionException;

/**
 * Parses user input and converts it into appropriate commands.
 */
public class Parser {

    private static TaskList taskList;

    /**
     * Parses the user input and returns the appropriate command.
     * @param input The user input to parse
     * @return The corresponding Command object
     * @throws InvalidDescriptionException if the command description is invalid
     */
    public static Command parseCommand(String input) throws InvalidDescriptionException {

        String stringParts[] = input.split(" ", 2);
        String command = stringParts[0];

        switch (command.toLowerCase()) {
        case "bye":
            Storage.saveFile(taskList);
            return new ExitCommand(input);
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
        case "find":
            return new FindCommand(input);
        default:
            throw new InvalidDescriptionException();
        }
    }
}

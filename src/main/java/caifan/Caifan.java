package caifan;

import caifan.commands.Command;
import caifan.exceptions.InvalidDescriptionException;

import java.util.Scanner;

public class Caifan {

    static boolean isExit = false;
    
    public static void main(String[] args) {
        Storage.createFile();
        TaskList.loadTaskList();
        Ui.printHelloMessage();
        Scanner in = new Scanner(System.in);

        while (!isExit) {
            try {
                String input = Ui.readCommand();
                Command c = Parser.parseCommand(input);
                c.execute();
                isExit = c.isExit();
            } catch (InvalidDescriptionException e) {
                Ui.handleInvalidCommand();
            }
        }
        Ui.printExitMessage();
    }
}

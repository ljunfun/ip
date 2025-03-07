package caifan;

import caifan.commands.Command;
import caifan.exceptions.InvalidDescriptionException;

import java.util.Scanner;

public class Caifan {

    static boolean isExit = false;

    //start of main loop
    public static void main(String[] args) {
        Storage.createFile();
        TaskList.loadTaskList();
        Ui.printHelloMessage();
        Scanner in = new Scanner(System.in);

        //loop to keep the scanner function running so that the bot is able to continuously obtain user inputs
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

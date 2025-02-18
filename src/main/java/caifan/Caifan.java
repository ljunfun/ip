package caifan;

import java.util.Scanner;

public class Caifan {

    private static TaskManager taskManager = new TaskManager();
    static boolean isActive = true;

    //start of main loop
    public static void main(String[] args) {


        taskManager.printHelloMessage();
        Scanner in = new Scanner(System.in);

        //loop to keep the scanner function running so that the bot is able to continuously obtain user inputs
        while (isActive) {
            String input = in.nextLine();
            taskManager.handleInput(input);
        }
        taskManager.printExitMessage();
    }
}

import java.util.Scanner;

public class Caifan {

    private static TaskManager taskManager = new TaskManager();
    static boolean isActive = true;

    public static void main(String[] args) {
        taskManager.printHelloMessage();
        Scanner in = new Scanner(System.in);

        while (isActive) {
            String input = in.nextLine();
            taskManager.handleInput(input);
        }
        taskManager.printExitMessage();
    }
}

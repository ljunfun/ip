package caifan;

import caifan.tasks.Task;

import java.util.Scanner;

import static caifan.TaskList.INDEX_OFFSET;

/**
 * Handles all user interface operations including input and output.
 * This class manages the display of messages and reading user commands.
 */
public class Ui {
    private static Scanner scanner = new Scanner(System.in);
    public static final String LINE = "\t____________________________________________________________";
    static TaskList taskList;

    /**
     * Prints a string message with a newline.
     * @param string The message to be printed
     */
    public static void println(String string) {
        System.out.println(string);
    }

    /**
     * Prints a divider line for visual separation.
     */
    public static void printLine() {
        System.out.println(LINE);
    }

    /**
     * Displays the welcome message when the application starts.
     */
    public static void printHelloMessage() {
        printLine();
        String welcomePhrase = "\tHello! I'm Caifan!\n" + "\tWhat can I do for you sweetheart <3?";
        println(welcomePhrase);
        printLine();
    }

    /**
     * Displays the goodbye message when the application exits.
     */
    public static void printExitMessage() {
        printLine();
        String goodbyePhrase = "\tBye byeee!! Hope to see you again soon <3";
        println(goodbyePhrase);
        printLine();
    }

    /**
     * Displays an error message when index is out of bounds.
     */
    public static void printOutOfBoundsError() {
        printLine();
        println("\tOh no!! Please enter a valid number >_<");
        printLine();
    }

    /**
     * Displays an error message when an invalid task number is provided.
     */
    public static void printInvalidTaskNumber() {
        printLine();
        println("\tAre you sure you gave me a number?! T_T");
        println("\tPlease try again! With a number this time >_>");
        printLine();
    }

    /**
     * Displays an error message for invalid commands.
     */
    public static void handleInvalidCommand() {
        printLine();
        println("\tHARH?! I do not understand what is that!!");
        println("\tPlease provide something that my smol brain can comprehend >_<");
        printLine();
    }

    /**
     * Displays all tasks in the current task list.
     */
    public static void printList() {
        printLine();
        println("\tHere is your To-do List!!");
        for (int i = 0; i < TaskList.getSize(); i++) {
            Task task = TaskList.getTask(i);
            println("\t" + (i + INDEX_OFFSET) + "." + task.toString());
        }
        printLine();
    }

    /**
     * Displays confirmation message after adding a new task.
     * @param task The task that was added
     */
    public static void printAddTask(Task task) {
        printLine();
        println("\tadded this for you my love <3:");
        println("\t  " + task.toString());
        println("\tNow you have " + taskList.getSize() + " tasks in the list.");
        printLine();
    }

    /**
     * Displays confirmation message after deleting a task.
     * @param removedTask The task that was removed
     */
    public static void printDeleteTask(Task removedTask) {
        printLine();
        println("\tOkie Dookie! I've removed this task:");
        println("\t  " + removedTask.toString());
        println("\tNow you have " + taskList.getSize() + " tasks in the list.");
        printLine();
    }

    /**
     * Displays confirmation message after marking a task as done.
     * @param index The index of the task that was marked as done
     */
    public static void printMark(int index) {
        printLine();
        println("\tYAY!! You have completed it :D");
        println("\t  " + taskList.getTask(index).toString());
        printLine();
    }

    /**
     * Displays confirmation message after unmarking a task as done.
     * @param index The index of the task that was marked as undone
     */
    public static void printUnmark(int index) {
        printLine();
        println("\tGet your lazy ass up and finish this >_<");
        println("\t  " + taskList.getTask(index).toString());
        printLine();
    }

    /**
     * Reads the next line of input from the user.
     * @return The command string entered by the user
     */
    public static String readCommand() {
        return scanner.nextLine();
    }
}

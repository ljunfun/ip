package caifan;

import caifan.tasks.Task;

import java.util.Scanner;

import static caifan.TaskList.INDEX_OFFSET;

public class Ui {
    private static Scanner scanner = new Scanner(System.in);
    public static final String LINE = "\t____________________________________________________________";
    static TaskList taskList;

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printLine() {
        System.out.println(LINE);
    }

    public static void printHelloMessage() {
        printLine();
        String welcomePhrase = "\tHello! I'm Caifan!\n" + "\tWhat can I do for you?";
        println(welcomePhrase);
        printLine();
    }

    public static void printExitMessage() {
        printLine();
        String goodbyePhrase = "\tBye byeee!! Hope to see you again soon <3";
        println(goodbyePhrase);
        printLine();
    }

    public static void printOutOfBoundsError() {
        printLine();
        println("\tOh no!! Please enter a valid number >_<");
        printLine();
    }

    public static void printInvalidTaskNumber() {
        printLine();
        println("\tAre you sure you gave me a number?! T_T");
        println("\tPlease try again! With a number this time >_>");
        printLine();
    }

    public static void handleInvalidCommand() {
        printLine();
        println("\tHARH?! I do not understand what is that!!");
        println("\tPlease provide something that my smol brain can comprehend >_<");
        printLine();
    }

    public static void printList() {
        printLine();
        println("\tHere is your To-do List!!");

        //loop to list all the tasks currently stored in taskList
        for (int i = 0; i < TaskList.getSize(); i++) {
            Task task = TaskList.getTask(i);
            println("\t" + (i + INDEX_OFFSET) + "." + task.toString());
        }
        printLine();
    }

    public static void printAddTask(Task task) {
        printLine();
        println("\tadded this for you my love <3:");
        println("\t  " + task.toString());
        println("\tNow you have " + taskList.getSize() + " tasks in the list.");
        printLine();
    }

    public static void printDeleteTask(Task removedTask) {
        printLine();
        println("\tNoted. I've removed this task:");
        println("\t  " + removedTask.toString());
        println("\tNow you have " + taskList.getSize() + " tasks in the list.");
        printLine();
    }

    public static void printMark(int index) {
        printLine();
        println("\tYAY!! You have completed it :D");
        println("\t  " + taskList.getTask(index).toString());
        printLine();
    }

    public static String readCommand() {
        return scanner.nextLine();
    }
}

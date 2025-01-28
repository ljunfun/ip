import java.util.Scanner;

public class Caifan {
    private static String[] taskList = new String[100];
    private static int taskCount = 0;

    public static void printLine() {
        String line = "\t____________________________________________________________";
        System.out.println(line);
    }
    public static void sayHello() {
        String welcomePhrase =  "\tHello! I'm Caifan!\n" + "\tWhat can I do for you?";
        System.out.println(welcomePhrase);
    }
    public static void sayGoodbye() {
        String goodbyePhrase = "\tBye. Hope to see you again soon <3";
        System.out.println(goodbyePhrase);
    }

    public static void addTask(String line) {
        printLine();
        System.out.println("\tadded this for you mi love: " + line);
        printLine();
    }

    public static void listTasks() {
        printLine();
        for (int i = 0; i < taskCount; i++) {
            System.out.println("\t" + (i + 1) + ". " + taskList[i]);
        }
        printLine();
    }

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

        //starting message
        printLine();
        sayHello();
        printLine();

        while (true) {
            line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                printLine();
                sayGoodbye();
                printLine();
                break;
            }else if (line.equalsIgnoreCase("list")) {
                listTasks();
            } else {
                taskList[taskCount] = line;
                taskCount++;
                addTask(line);
            }
        }
    }
}

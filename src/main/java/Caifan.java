import java.util.Scanner;

public class Caifan {
    private static Task[] taskList = new Task[100];
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
        String goodbyePhrase = "\tBye byeee!! Hope to see you again soon <3";
        System.out.println(goodbyePhrase);
    }

    public static void addTask(String line) {
        printLine();
        System.out.println("\tadded this for you my love: " + line);
        printLine();
    }

    //list down tasks with its status
    public static void listTasks() {
        printLine();
        System.out.println("\tHere is your To-do List!!");
        for (int i = 0; i < taskCount; i++) {
            Task task = taskList[i];
            System.out.println("\t" + (i + 1) + ".["+task.getStatusIcon()+"] " + task.getDescription());
        }
        printLine();
    }

    //set task as complete
    public static void markTask(int index) {
        if (index >= 0 && index < taskCount) {
            taskList[index].setDone(true);
            printLine();
            System.out.println("\tYAY!! You have completed it :D");
            System.out.println("\t  " + "["+taskList[index].getStatusIcon()+"] " + taskList[index].getDescription());
            printLine();
        }
    }

    //set task as incomplete
    public static void unmarkTask(int index) {
        if (index >= 0 && index < taskCount) {
            taskList[index].setDone(false);
            printLine();
            System.out.println("\tGet your lazy ass up and finish this ><");
            System.out.println("\t  " + "["+taskList[index].getStatusIcon()+"] " + taskList[index].getDescription());
            printLine();
        }
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
            if (line.equalsIgnoreCase("bye")) { //goodbye message
                printLine();
                sayGoodbye();
                printLine();
                break;
            } else if (line.equalsIgnoreCase("list")) { //prints the list
                listTasks();
            } else if (line.startsWith("mark ")) {
                int index = Integer.parseInt(line.substring(5)) - 1;
                markTask(index);
            } else if (line.startsWith("unmark ")) {
                int index = Integer.parseInt(line.substring(7)) - 1;
                unmarkTask(index);
            } else { //add task to list and track number of tasks
                taskList[taskCount] = new Task(line);
                taskCount++;
                addTask(line);
            }
        }
    }
}

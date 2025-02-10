import java.util.Scanner;

public class Caifan {
    private static Task[] taskList = new Task[100];
    private static int taskCount = 0;

    public static void printLine() {
        final String LINE = "\t____________________________________________________________";
        System.out.println(LINE);
    }

    public static void sayHello() {
        String welcomePhrase =  "\tHello! I'm Caifan!\n" + "\tWhat can I do for you?";
        System.out.println(welcomePhrase);
    }

    public static void sayGoodbye() {
        String goodbyePhrase = "\tBye byeee!! Hope to see you again soon <3";
        System.out.println(goodbyePhrase);
    }

    public static void printInvalidCommand() {
        printLine();
        System.out.println("\tHARH?! I do not understand what is that!!");
        System.out.println("\tPlease handle something that my smol brain can comprehend >_<");
        printLine();
    }

    public static void printOutOfBoundsError() {
        printLine();
        System.out.println("\tOh no!! Please enter a valid number >_<");
        printLine();
    }

    public static void printInvalidTaskNumber() {
        printLine();
        System.out.println("\tAre you sure you gave me a number?! :((");
        System.out.println("\tPlease try again! With a number this time >_>");
        printLine();
    }

    public static void addTask(Task task) {
        taskList[taskCount] = task;
        taskCount++;
        printLine();
        System.out.println("\tadded this for you my love <3:");
        System.out.println("\t  " + task.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
        printLine();
    }

    //list down tasks with its status
    public static void listTasks() {
        printLine();
        System.out.println("\tHere is your To-do List!!");
        for (int i = 0; i < taskCount; i++) {
            Task task = taskList[i];
            System.out.println("\t" + (i + 1) + "." + task.toString());
        }
        printLine();
    }

    //set task as complete
    public static void markTask(int index) {
        if (index >= 0 && index < taskCount) {
            taskList[index].setDone(true);
            printLine();
            System.out.println("\tYAY!! You have completed it :D");
            System.out.println("\t  " + taskList[index].toString());
            printLine();
        } else {
            throw new RuntimeException();
        }
    }

    //set task as incomplete
    public static void unmarkTask(int index) {
        if (index >= 0 && index < taskCount) {
            taskList[index].setDone(false);
            printLine();
            System.out.println("\tGet your lazy ass up and finish this >_<");
            System.out.println("\t  " + taskList[index].toString());
            printLine();
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        String userInput;
        Scanner in = new Scanner(System.in);

        //starting message
        printLine();
        sayHello();
        printLine();

        while (true) {
            userInput = in.nextLine();
            String stringParts[] = userInput.split(" ", 2);
            String command = stringParts[0];
            String description = stringParts[1];

            switch (command.toLowerCase()) {
            case "bye":
                printLine();
                sayGoodbye();
                printLine();
                break;
            case "list":
                listTasks();
                break;
            case "mark":
                try {
                    int index = Integer.parseInt(description) - 1;
                    markTask(index);
                } catch (IndexOutOfBoundsException e) {
                    printOutOfBoundsError();
                } catch (NumberFormatException e) {
                    printInvalidTaskNumber();
                }
                break;
            case "unmark":
                try {
                    int index = Integer.parseInt(description) - 1;
                    unmarkTask(index);
                } catch (IndexOutOfBoundsException e) {
                    printOutOfBoundsError();
                } catch (NumberFormatException e) {
                    printInvalidTaskNumber();
                }
                break;
            case "todo":
                try {
                    if (description.isBlank()) {
                        throw new InvalidDescriptionException();
                    }
                    addTask(new Todo (description));
                } catch (InvalidDescriptionException e) {
                    System.out.println("\tWhy is your description empty?!! Put somwthing there >_<");
                }
                break;
            case "deadline":
                try {
                    String[] parts = description.split(" /by ");
                    String splitDescription = parts[0];
                    String deadline = parts[1];
                    if (splitDescription.isBlank() || deadline.isBlank()) {
                        throw new InvalidDescriptionException();
                    }
                    addTask(new Deadline(splitDescription, deadline));
                } catch (InvalidDescriptionException e) {
                    System.out.println("\tWhy is your description/deadline empty?!! Put something there >_<");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\tPlease input your deadline or description properly, HMPH :<");
                }
                break;
            case "event":
                try {
                    String[] parts = description.split(" /from | /to ");
                    String splitDescription = parts[0];
                    String start = parts[1];
                    String end = parts[2];
                    if (splitDescription.isBlank() || start.isBlank() || end.isBlank()) {
                        throw new InvalidDescriptionException();
                    }
                    addTask(new Event(splitDescription, start, end));
                } catch (InvalidDescriptionException e) {
                    System.out.println("\tWhy is your description or start/end dates empty?!! Put something there >_<");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\tPlease input your deadline or start/end dates properly, HMPH :<");
                }
                break;
            default:
                printInvalidCommand();
                break;
            }
        }
    }
}

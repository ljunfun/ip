import caifan.exceptions.InvalidDescriptionException;
import caifan.tasks.Deadline;
import caifan.tasks.Event;
import caifan.tasks.Task;
import caifan.tasks.Todo;

import java.util.ArrayList;

public class TaskManager {

    private static ArrayList<Task> taskList = new ArrayList<>();
    private static int taskCount = 0;
    public static final String LINE = "\t____________________________________________________________";
    public static final int INDEX_OFFSET = 1;
    public static final int DESCRIPTION_INDEX = 1;

    public static void printLine() {
        System.out.println(LINE);
    }

    public static void printHelloMessage() {
        printLine();
        String welcomePhrase = "\tHello! I'm Caifan!\n" + "\tWhat can I do for you?";
        System.out.println(welcomePhrase);
        printLine();
    }

    public static void printExitMessage() {
        printLine();
        String goodbyePhrase = "\tBye byeee!! Hope to see you again soon <3";
        System.out.println(goodbyePhrase);
        printLine();
    }

    /* print an error whenever an number is being entered that is
     * bounds of the available index arrays
     */
    public static void printOutOfBoundsError() {
        printLine();
        System.out.println("\tOh no!! Please enter a valid number >_<");
        printLine();
    }

    /* prints an error whenever the user attempts to input something that
     * is not a number into the system
     */

    public static void printInvalidTaskNumber() {
        printLine();
        System.out.println("\tAre you sure you gave me a number?! T_T");
        System.out.println("\tPlease try again! With a number this time >_>");
        printLine();
    }

    //processes the tasks according to the command word that is processed
    public static void addTask(Task task) {
        taskList.add(task);
        taskCount++;

        printLine();
        System.out.println("\tadded this for you my love <3:");
        System.out.println("\t  " + task.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
        printLine();
    }

    //processes invalid inputs for commands that are not part of the list of commands accepted
    public static void handleInvalidCommand() {
        printLine();
        System.out.println("\tHARH?! I do not understand what is that!!");
        System.out.println("\tPlease provide something that my smol brain can comprehend >_<");
        printLine();
    }

    //list down tasks with its status
    public static void handleList() {
        printLine();
        System.out.println("\tHere is your To-do List!!");

        //loop to list all the tasks currently stored in taskList
        for (int i = 0; i < taskCount; i++) {
            Task task = taskList.get(i);
            System.out.println("\t" + (i + INDEX_OFFSET) + "." + task.toString());
        }
        printLine();
    }

    //set task as complete
    public static void handleMark(String input) {
        try {
            //obtain the task number to be marked
            String indexNumber = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            int index = Integer.parseInt(indexNumber) - INDEX_OFFSET;

            //to catch inputs that out of legal bounds of the array initialised
            if (index < 0 && index >= taskCount) {
                throw new IndexOutOfBoundsException();
            } else {
                taskList.get(index).setDone(true);
            }

            printLine();
            System.out.println("\tYAY!! You have completed it :D");
            System.out.println("\t  " + taskList.get(index).toString());
            printLine();

        } catch (IndexOutOfBoundsException e) {
            printOutOfBoundsError();
        } catch (NumberFormatException e) {
            printInvalidTaskNumber();
        }
    }

    //set task as incomplete
    public static void handleUnmark(String input) {
        try {
            //obtain the task number to be unmarked
            String indexNumber = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            int index = Integer.parseInt(indexNumber) - INDEX_OFFSET;

            //to catch inputs that out of legal bounds of the array initialised
            if (index < 0 && index >= taskCount) {
                throw new IndexOutOfBoundsException();
            } else {
                taskList.get(index).setDone(false);
            }

            printLine();
            System.out.println("\tGet your lazy ass up and finish this >_<");
            System.out.println("\t  " + taskList.get(index).toString());
            printLine();

        } catch (IndexOutOfBoundsException e) {
            printOutOfBoundsError();
        } catch (NumberFormatException e) {
            printInvalidTaskNumber();
        }
    }

    //delete a task from list
    public static void handleDelete(String input) {
        try {
            String indexNumber = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            int index = Integer.parseInt(indexNumber) - INDEX_OFFSET;

            Task removedTask = taskList.remove(index);
            taskCount--;

            printLine();
            System.out.println("\tNoted. I've removed this task:");
            System.out.println("\t  " + removedTask.toString());
            System.out.println("\tNow you have " + taskCount + " tasks in the list.");
            printLine();

        } catch (IndexOutOfBoundsException e) {
            printOutOfBoundsError();
        } catch (NumberFormatException e) {
            printInvalidTaskNumber();
        }
    }

    //adds a to-do task into the list
    public static void handleTodo(String input) {
        try {
            //obtain the task to be completed
            String description = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);

            //catches an empty description and throws an error accordingly
            if (description.isBlank() || !input.contains(" ")) {
                throw new InvalidDescriptionException();
            }
            addTask(new Todo(description));

        } catch (InvalidDescriptionException e) {
            printLine();
            System.out.println("\tWhy is your description empty?!! Put something there >_<");
            printLine();
        }
    }

    //adds a task with a description and a deadline into the list
    public static void handleDeadline(String input) {
        try {
            //obtain the description and the deadline
            String description = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);

            //split the string according to the word that separates the description and the deadline
            String[] parts = description.split(" /by ");
            String splitDescription = parts[0];
            String deadline = parts[1];

            addTask(new Deadline(splitDescription, deadline));

        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("\tWhy is your description/deadline empty?!! Put something there >_<");
            System.out.println("\tPlease input a valid deadline or description, HMPH :<");
            printLine();
        }
    }

    //adds an event task with a description, start and end dates to the list
    public static void handleEvent(String input) {
        try {
            String description = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            /* split the string according to the word that separates the description,
             * the start date and the end date
             */
            String[] parts = description.split(" /from | /to ");
            String splitDescription = parts[0];
            String start = parts[1];
            String end = parts[2];

            addTask(new Event(splitDescription, start, end));

        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("\tWhy is your description or start/end dates empty?!! Put something there >_<");
            System.out.println("\tPlease input a valid event or start/end dates, HMPH :<");
            printLine();
        }
    }

    //main logic that processes the commands as they are sifted with the input
    public static void handleInput(String input) {
        String stringParts[] = input.split(" ", 2);
        String command = stringParts[0];

        switch (command.toLowerCase()) {
        case "bye":
            Caifan.isActive = false;
            return;
        case "list":
            handleList();
            break;
        case "mark":
            handleMark(input);
            break;
        case "unmark":
            handleUnmark(input);
            break;
        case "todo":
            handleTodo(input);
            break;
        case "deadline":
            handleDeadline(input);
            break;
        case "event":
            handleEvent(input);
            break;
        case "delete":
            handleDelete(input);
            break;
        default:
            handleInvalidCommand();
            break;
        }
    }
}

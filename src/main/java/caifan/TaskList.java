package caifan;

import caifan.exceptions.InvalidDescriptionException;
import caifan.tasks.Task;

import java.util.ArrayList;

/**
 * Handles all task list operations and management of tasks.
 */
public class TaskList {
    private static ArrayList<Task> taskList = new ArrayList<>();
    public static final int INDEX_OFFSET = 1;
    public static final int DESCRIPTION_INDEX = 1;

    /**
     * Loads the task list from storage.
     */
    public static void loadTaskList() {
        Storage.loadData(taskList);
    }

    /**
     * Gets a task at the specified index.
     * @param index The index of the task to retrieve
     * @return The task at the specified index
     */
    public static Task getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Gets the current size of the task list.
     * @return The number of tasks in the list
     */
    public static int getSize() {
        return taskList.size();
    }

    /**
     * Adds a new task to the list and displays confirmation.
     * @param task The task to be added
     */
    public static void addTask(Task task) {
        taskList.add(task);
        Ui.printAddTask(task);
    }

    /**
     * Deletes a task based on the user input index.
     * @param input User input containing the index to delete
     */
    public static void deleteTask(String input) {
        try {
            String indexNumber = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            int index = Integer.parseInt(indexNumber) - INDEX_OFFSET;
            Task removedTask = taskList.remove(index);
            Ui.printDeleteTask(removedTask);
        } catch (IndexOutOfBoundsException e) {
            Ui.printOutOfBoundsError();
        } catch (NumberFormatException e) {
            Ui.printInvalidTaskNumber();
        }
    }

    /**
     * Searches for tasks containing the specified keyword.
     * @param input User input containing the search keyword
     */
    public static void handleFind(String input) {
        try {
            String keyword = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            if (keyword.isBlank() || !input.contains(" ")) {
                throw new InvalidDescriptionException();
            }

            ArrayList<Task> tasksWithKeyword = new ArrayList<>();
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                if (task.getDescription().toLowerCase().contains(keyword)) {
                    tasksWithKeyword.add(task);
                }
            }
            Ui.printLine();
            if (tasksWithKeyword.isEmpty()) {
                Ui.println("\tNo matching tasks found TT");
            } else {
                Ui.println("Here are some matching tasks in the list ᕕ(╯°□°)ᕗ:");
                for (int i = 0; i < tasksWithKeyword.size(); i++) {
                    Ui.println("\t" + (i + INDEX_OFFSET) + ". " + tasksWithKeyword.get(i).toString());
                }
            }
            Ui.printLine();
        } catch (InvalidDescriptionException e) {
            Ui.printLine();
            Ui.println("\tWhy is your description empty?!! Put something there >_<");
            Ui.printLine();
        }
    }

    /**
     * Marks a task as done based on the user input index.
     * @param input User input containing the index to mark
     */
    public static void handleMark(String input) {
        try {
            String indexNumber = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            int index = Integer.parseInt(indexNumber) - INDEX_OFFSET;

            if (index < 0 && index >= taskList.size()) {
                throw new IndexOutOfBoundsException();
            } else {
                taskList.get(index).setDone(true);
            }
            Ui.printMark(index);
        } catch (IndexOutOfBoundsException e) {
            Ui.printOutOfBoundsError();
        } catch (NumberFormatException e) {
            Ui.printInvalidTaskNumber();
        }
    }

    /**
     * Unmarks a task as done based on the user input index.
     * @param input User input containing the index to unmark
     */
    public static void handleUnmark(String input) {
        try {
            //obtain the task number to be unmarked
            String indexNumber = input.substring(input.indexOf(" ") + DESCRIPTION_INDEX);
            int index = Integer.parseInt(indexNumber) - INDEX_OFFSET;

            //to catch inputs that out of legal bounds of the array initialised
            if (index < 0 && index >= taskList.size()) {
                throw new IndexOutOfBoundsException();
            } else {
                taskList.get(index).setDone(false);
            }

            Ui.printLine();
            System.out.println("\tGet your lazy ass up and finish this >_<");
            System.out.println("\t  " + taskList.get(index).toString());
            Ui.printLine();

        } catch (IndexOutOfBoundsException e) {
            Ui.printOutOfBoundsError();
        } catch (NumberFormatException e) {
            Ui.printInvalidTaskNumber();
        }
    }

}
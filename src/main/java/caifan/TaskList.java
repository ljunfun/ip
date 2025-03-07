package caifan;

import caifan.tasks.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList = new ArrayList<>();
    public static final int INDEX_OFFSET = 1;
    public static final int DESCRIPTION_INDEX = 1;

    public static void loadTaskList() {
        Storage.loadData(taskList);
    }

    public static Task getTask(int index) {
        return taskList.get(index);
    }

    public static int getSize() {
        return taskList.size();
    }

    public static void addTask(Task task) {
        taskList.add(task);
        Ui.printAddTask(task);
    }

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
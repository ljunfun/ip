package caifan;

import caifan.tasks.Deadline;
import caifan.tasks.Event;
import caifan.tasks.Task;
import caifan.tasks.Todo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public static final String FILE_DIR = "./data";
    public static final String FILE_PATH = "./data/Caifan.txt";

    public static void loadData(ArrayList<Task> taskList) {
        File file = new File(FILE_PATH);
        int currentIndex = 0;

        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String input = s.nextLine();
                String[] splitInput = input.split(" \\| ");
                boolean isDone;
                switch (splitInput[0].toUpperCase()) {
                case "T":
                    isDone = splitInput[1].equals("1");
                    taskList.add(new Todo(splitInput[2]));
                    if (isDone) {
                        taskList.get(currentIndex).setDone(true);
                    }
                    currentIndex++;
                    break;
                case "D":
                    isDone = splitInput[1].equals("1");
                    if (splitInput.length >= 4) {
                        taskList.add(new Deadline(splitInput[2], splitInput[3]));
                    }
                    if (isDone) {
                        taskList.get(currentIndex).setDone(true);
                    }
                    currentIndex++;
                    break;
                case "E":
                    isDone = splitInput[1].equals("1");
                    if (splitInput.length >= 5) {
                        taskList.add(new Event(splitInput[2], splitInput[3], splitInput[4]));
                    }
                    if (isDone) {
                        taskList.get(currentIndex).setDone(true);
                    }
                    currentIndex++;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static String taskToString(Task task) {
        String type = task.getType();
        boolean status = task.isDone();

        String description = task.getDescription();
        switch (type) {
        case "T":
            return type + " | " + (status ? "1" : "0") + " | " + description;
        case "D":
            return type + " | " + (status ? "1" : "0") + " | " + description + " | " + ((Deadline)task).getDeadline();
        case "E":
            return type + " | " + (status ? "1" : "0") + " | " + description + " | " + ((Event)task).getStart() +
                    " | " + ((Event)task).getEnd();
        default:
            return "Unknown task type";
        }
    }

    public static void saveFile(TaskList taskList) {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (int i = 0; i < taskList.getSize(); i++) {
                fw.write(taskToString(taskList.getTask(i)) + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public static void createFile() {
        File dir = new File(FILE_DIR);
        File f = new File(FILE_PATH);

        if (!dir.exists() && !dir.mkdir()) {
            System.out.println("Error creating directory: " + FILE_PATH);
        }
        if (!f.exists()) {
            try {
               if (f.createNewFile()) {
                   System.out.println("Created file");
               }

            } catch (IOException e) {
                System.out.println("Error creating file: " + FILE_PATH);
            }
        }
    }
}

package caifan;

import caifan.tasks.Deadline;
import caifan.tasks.Event;
import caifan.tasks.Task;
import caifan.tasks.Todo;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public static final int INDEX_OFFSET = 1;
    public static final String FILE_DIR = "./data";
    public static final String FILE_PATH = "./data/Caifan.txt";

    public static void loadData(ArrayList<Task> taskList) {
        File file = new File(FILE_PATH);

        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String input = s.nextLine();
                String[] splitInput = input.split(" \\| ");
                switch (splitInput[0].toUpperCase()) {
                case "T":
                    taskList.add(new Todo(splitInput[2]));
                case "D":
                    taskList.add(new Deadline(splitInput[2], splitInput[3]));
                case "E":
                    taskList.add(new Event(splitInput[2], splitInput[3], splitInput[4]));
                }
                if (splitInput[1].equals("✔")) {
                    taskList.get(taskList.size() - INDEX_OFFSET).setDone(true);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static String taskToString(Task task) {
        String type = task.getType();
        String status = task.getStatusIcon();
        String description = task.getDescription();
        switch (type) {
        case "T":
            return type + " | " + status + " | " + description;
        case "D":
            return type + " | " + status + " | " + description + " | " + ((Deadline)task).getDeadline();
        case "E":
            return type + " | " + status + " | " + description + " | " + ((Event)task).getStart() +
                    " | " + ((Event)task).getEnd();
        default:
            return "Unknown task type";
        }
    }

    public static void loadFile(ArrayList<Task> taskList) {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (Task task : taskList) {
                int index = 0;
                fw.write(taskToString(taskList.get(index)));
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public static void createFile() {
        File dir = new File(FILE_DIR);
        dir.mkdir();
        try {
            File f = new File(FILE_PATH);
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating file: " + FILE_PATH);
        }
    }
}

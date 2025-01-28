import java.util.Arrays;
import java.util.Scanner;

public class Stanley {
    public static void printLine() {
        String line = "____________________________________________________________";
        System.out.println(line);
    }
    public static void sayHello() {
        String welcomePhrase =  "Hello! I'm Stanley!\n" +
                "What can I do for you?";
        System.out.println(welcomePhrase);
    }
    public static void sayGoodbye() {
        String goodbyePhrase = "Bye. Hope to see you again soon!";
        System.out.println(goodbyePhrase);
    }

    public static void echoWord(String line) {
        printLine();
        System.out.println(line);
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
            }
            echoWord(line);
        }
    }
}

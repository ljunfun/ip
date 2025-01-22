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
    public static void main(String[] args) {
        printLine();
        sayHello();
        printLine();
        sayGoodbye();
        printLine();
    }
}

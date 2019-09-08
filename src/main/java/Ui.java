import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static ArrayList<String> dukeReply = new ArrayList<String>();
    String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    Scanner inputScanner = new Scanner(System.in);

    void showWelcome() {
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }

    String readCommand() {
        return inputScanner.nextLine();
    }

    void showLine() {
        String border = "        ____________________________________________________________";
        System.out.println(border);
    }

    void addLine(String newLine) {
        dukeReply.add(newLine);
    }

    void showLoadingError() {
        dukeReply.add("Error loading from save file.");
        giveReply();
    }

    void giveReply() {
        for (String s: dukeReply) {
            String paddedS = "        " + s;
            System.out.println(paddedS);
        }
        dukeReply.clear();
    }
}
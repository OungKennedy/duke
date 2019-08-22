import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * handles all the tasks.
 */

public class taskMaster {
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void addTask(String Description) {
        Task newTask = new Task(Description);
        taskList.add(newTask);
    }

    public static void listTasks() {
        int counter = 1;
        for (Task t: taskList) {
            System.out.print(counter++);
            System.out.println(": " + t.description);
        }
    }
}

import java.util.ArrayList;
import java.util.Collection;

public class TaskList {
    public static ArrayList<Task> tasks = new ArrayList<>();
    static int totalTasks;
    TaskList(ArrayList<Task> ...taskArray) {
        // if initialized with no params treat as new task list is created.
        if (taskArray.length == 0) {
            return;
        }
        // if there is a list with nonzero elements then add the to tasks.
        tasks.addAll(taskArray[0]);
    }
    void addTask(Task newTask){
        tasks.add(newTask);
    };

    static int getTotalTasks() {
        return tasks.size();
    }


}

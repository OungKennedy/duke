import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * handles all the tasks.
 */

class TaskMaster {
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    static void addTask(String description) {
        Task newTask = new Task(description);
        taskList.add(newTask);
    }
    /** Function that inserts task description and status icon into an ArrayList.
     * @return an array list of (Strings) tasks.
     * */

    static ArrayList<String> listTasks() {
        ArrayList<String> taskarrayList = new ArrayList<String>();
        taskarrayList.add("Here are the tasks in your list:");
        int counter = 1;
        for (Task t: taskList) {
            String tasklistEntry = "";
            tasklistEntry += counter++;
            String statusIcon = t.getStatusIcon();
            tasklistEntry += ". " + statusIcon + " " + t.description;
            taskarrayList.add(tasklistEntry);
        }
        return taskarrayList;
    }

    /**
     * Sets task as done, and return array list of replies to handle_input function.
     * @param taskIndex : Integer representing index of task to mark as done.
     * @return reply : an ArrayList of Strings containing the replies to return to handle_input function.
     */

    static ArrayList<String> resolveTask(Integer taskIndex) {
        ArrayList<String> reply = new ArrayList<String>();
        reply.add("Nice! I've marked this task as done:");
        Task doneTask = taskList.get(taskIndex);
        reply.add(String.format("%s✓] %s", '[', doneTask.description));
        doneTask.markAsDone();
        taskList.set(taskIndex, doneTask);
        return reply;
    }

}

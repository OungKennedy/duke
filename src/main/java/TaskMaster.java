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
    /** Function that inserts task description and status icon into an ArrayList
     * @return an array list of (Strings) tasks
     * */

    static ArrayList<String> listTasks() {
        ArrayList<String> TaskList = new ArrayList<String>();
        TaskList.add("Here are the tasks in your list:");
        int counter = 1;
        for (Task t: taskList) {
            String TaskListEntry = "";
            TaskListEntry += counter++;
            String statusIcon = t.getStatusIcon();
            TaskListEntry += ". " + statusIcon + " " + t.description;
            TaskList.add(TaskListEntry);
        }
        return TaskList;
    }

    /**
     * Sets task as done, and return array list of replies to handle_input function
     * @param taskIndex: Integer representing index of task to mark as done.
     * @return reply: an ArrayList<String> containing the replies to return to handle_input function.
     */

    static ArrayList<String> resolveTask(Integer taskIndex) {
        ArrayList<String> reply = new ArrayList<String>();
        reply.add("Nice! I've marked this task as done:");
        Task doneTask = taskList.get(taskIndex);
        reply.add('[' + "\u2713" + ']' + " " + doneTask.description);
        doneTask.markAsDone();
        taskList.set(taskIndex, doneTask);
        return reply;
    }

}

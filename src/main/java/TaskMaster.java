import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * handles all the tasks.
 */

class TaskMaster {
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    static ArrayList<String> addTask(String userInput) {
        ArrayList<String> addTaskArrayList = new ArrayList<String>();
        addTaskArrayList.add("Got it. I've added this task");
        String description = "";
        String time = "";
        String taskType = userInput.split(" ",2)[0];
        if (taskType.equals("todo")) {
            description = userInput.split(" ",2)[1];
            Todo newTodo = new Todo(description);
            taskList.add(newTodo);
            addTaskArrayList.add(newTodo.toString());
        } else if (taskType.equals("deadline")) {
            description = userInput.split(" ",2)[1].split(" /.. ")[0];
            time = userInput.split(" ",2)[1].split(" /.. ")[1];
            Deadline newDeadline = new Deadline(description,time);
            taskList.add(newDeadline);
            addTaskArrayList.add(newDeadline.toString());
        } else {
            description = userInput.split(" ",2)[1].split(" /.. ")[0];
            time = userInput.split(" ",2)[1].split(" /.. ")[1];
            Event newEvent = new Event(description,time);
            taskList.add(newEvent);
            addTaskArrayList.add(newEvent.toString());
        }
        addTaskArrayList.add(String.format("Now you have %d tasks in the list.", taskList.size()));
        return addTaskArrayList;
    }
    /** Function that inserts task description and status icon into an ArrayList.
     * @return an array list of (Strings) tasks.
     * */

    static ArrayList<String> listTasks() {
        ArrayList<String> taskarrayList = new ArrayList<String>();
        taskarrayList.add("Here are the tasks in your list:");
        int counter = 1;
        for (Task t: taskList) {
            taskarrayList.add(t.toString());
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

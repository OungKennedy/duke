import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * handles all the tasks.
 */

class TaskMaster {
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    static ArrayList<String> addTask(String userInput) throws EmptyDescriptionException, InvalidTaskTypeException {
        ArrayList<String> addTaskArrayList = new ArrayList<String>();
        addTaskArrayList.add("Got it. I've added this task");
        String description = "";
        String time = "";
        String[] inputDetails = userInput.split(" ", 2);
        String taskType = inputDetails[0];
        if (inputDetails.length == 1) {
            throw new EmptyDescriptionException("☹ OOPS!!! The description of a task cannot be empty.");
        }
        switch (taskType) {
        case "todo":
            description = userInput.split(" ", 2)[1];
            Todo newTodo = new Todo(description);
            taskList.add(newTodo);
            addTaskArrayList.add(newTodo.toString());
            break;
        case "deadline":
            description = userInput.split(" ", 2)[1].split(" /.. ")[0];
            time = userInput.split(" ", 2)[1].split(" /.. ")[1];
            Deadline newDeadline = new Deadline(description, time);
            taskList.add(newDeadline);
            addTaskArrayList.add(newDeadline.toString());
            break;
        case "event":
            description = userInput.split(" ", 2)[1].split(" /.. ")[0];
            time = userInput.split(" ", 2)[1].split(" /.. ")[1];
            Event newEvent = new Event(description, time);
            taskList.add(newEvent);
            addTaskArrayList.add(newEvent.toString());
            break;
        default:
            throw new InvalidTaskTypeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        addTaskArrayList.add(String.format("Now you have %d tasks in the list.", taskList.size()));
        return addTaskArrayList;
    }
    /** Function that inserts task description and status icon into an ArrayList.
     * @return an array list of (Strings) tasks.
     * */

    static ArrayList<String> listTasks() {
        ArrayList<String> taskArrayList = new ArrayList<String>();
        taskArrayList.add("Here are the tasks in your list:");
        int counter = 1;
        for (Task t: taskList) {
            taskArrayList.add(counter++ + ". " + t.toString());
        }
        return taskArrayList;
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

    /**
     * Function to save task information to file
     * @throws IOException: invalid input/ output?
     */
    public static void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/oungk/OneDrive/Documents/School Work/CS2113/duke/data/duke.txt"));
        for (int i = 0; i < taskList.size(); i += 1) {
            String tasksaveData = taskList.get(i).toSaveData();
            writer.write(tasksaveData);
            writer.newLine();
        }
        writer.close();
    }

    /**
     * Function to read from save file. Called on duke launch.
     * @throws FileNotFoundException
     */

    static void readFromSave() throws FileNotFoundException {
        try {
            Scanner in = new Scanner(new FileReader("C:/Users/oungk/OneDrive/Documents/School Work/CS2113/duke/data/duke.txt"));
            while (in.hasNext()) {
                String newTask = in.nextLine();
                addTaskFromSave(newTask);
            }
        } catch (FileNotFoundException | InvalidTaskTypeException ignored) {
        }
    }

    /**
     * Function to add task to taskList from line in save file.
     * @param TaskString String that contains information from save file. In the format of (task type | isDone | Description | by/at )
     * @throws InvalidTaskTypeException
     */
    private static void addTaskFromSave(String TaskString) throws InvalidTaskTypeException {
        String[] taskDetails = TaskString.split("\\|");
        switch (taskDetails[0]) {
            case "[D]":
                Deadline newDeadline = new Deadline(taskDetails[2],taskDetails[3]);
                newDeadline.isDone = taskDetails[1].equals("1");
                taskList.add(newDeadline);
                break;

            case "[E]":
                Event newEvent = new Event(taskDetails[2],taskDetails[3]);
                newEvent.isDone = taskDetails[1].equals("1");
                taskList.add(newEvent);
                break;

            case "[T]":
                Todo newTodo = new Todo(taskDetails[2]);
                newTodo.isDone = taskDetails[1].equals("1");
                taskList.add(newTodo);
                break;

            default:
                System.out.println("error" + taskDetails[0]);
                throw new InvalidTaskTypeException("error loading saved task. current line: " + TaskString);
        }

    }
}

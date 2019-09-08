import java.util.ArrayList;

public class LoadCommand extends Command {
    String[] taskDetails;

    LoadCommand(String[] taskDetails) {
        this.taskDetails = taskDetails;
    }

    void execute(ArrayList<Task> tasks) throws InvalidTaskTypeException {
        switch (taskDetails[0]) {
        case "[D]":
            Deadline newDeadline = new Deadline(taskDetails[2],taskDetails[3]);
            newDeadline.isDone = taskDetails[1].equals("1");
            tasks.add(newDeadline);
            break;
        case "[E]":
            Event newEvent = new Event(taskDetails[2],taskDetails[3]);
            newEvent.isDone = taskDetails[1].equals("1");
            tasks.add(newEvent);
            break;
        case "[T]":
            Todo newTodo = new Todo(taskDetails[2]);
            newTodo.isDone = taskDetails[1].equals("1");
            tasks.add(newTodo);
            break;
        default:
            throw new InvalidTaskTypeException("Wrong task type in save file:" + taskDetails[0]);
        }
    }
}

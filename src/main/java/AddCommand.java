class AddCommand extends Command {
    private String[] taskDetails;

    AddCommand(String[] taskDetails) {
        this.taskDetails = taskDetails;
    }

    void execute(TaskList tasks, Ui ui, Storage storage) throws InvalidDataException {
        ui.addLine("Got it. I've added this task:");
        switch (taskDetails[0]) {
        case "todo" :
            Todo newTodo = new Todo(taskDetails[1]);
            tasks.addTask(newTodo);
            ui.addLine("  " + newTodo.toString());
            break;
        case "deadline":
            Deadline newDeadline = new Deadline(taskDetails[1], taskDetails[2]);
            tasks.addTask(newDeadline);
            ui.addLine("  " + newDeadline.toString());
            break;
        case "event":
            Event newEvent = new Event(taskDetails[1], taskDetails[2]);
            tasks.addTask(newEvent);
            ui.addLine("  " + newEvent.toString());
            break;
        default:
            throw new InvalidDataException("invalid task type");
        }

        ui.giveReply();
    }
}

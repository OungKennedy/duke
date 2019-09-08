public class DoneCommand extends Command {
    private int doneIndex;

    public DoneCommand(int doneIndex) {
        this.doneIndex = doneIndex;
    }

    /**
     * function that marks the task as done.
     * @param tasks list of tasks.
     * @param ui ui object of duke.
     * @param storage storage object of duke.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.tasks.get(doneIndex);
        ui.addLine("Noted. I've noted this task as completed:");
        ui.addLine("  " + t.toString());
        TaskList.tasks.remove(t);
        ui.addLine(String.format("Now you have %d tasks in the list.",TaskList.getTotalTasks()));
        ui.giveReply();
    }
}

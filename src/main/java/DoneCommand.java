public class DoneCommand extends Command {
    private int doneIndex;

    public DoneCommand(int doneIndex) {
        this.doneIndex = doneIndex;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.tasks.get(doneIndex);
        ui.addLine("Noted. I've noted this task as completed:");
        ui.addLine("  " + t.toString());
        TaskList.tasks.remove(t);
        ui.addLine(String.format("Now you have %d tasks in the list.",TaskList.getTotalTasks()));
        ui.giveReply();
    }
}

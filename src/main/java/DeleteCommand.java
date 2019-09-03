class DeleteCommand extends Command {
    private int deleteIndex;
    public DeleteCommand(int deleteIndex) {
        this.deleteIndex = deleteIndex;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.tasks.get(deleteIndex);
        ui.addLine("Noted. I've removed this task:");
        ui.addLine("  " + t.toString());
        TaskList.tasks.remove(t);
        ui.addLine(String.format("Now you have %d tasks in the list.",TaskList.getTotalTasks()));
        ui.giveReply();
    }

}

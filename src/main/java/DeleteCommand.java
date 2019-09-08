class DeleteCommand extends Command {
    private int deleteIndex;
    // deleteIndex - 1 for 1 indexing

    DeleteCommand(int deleteIndex) {
        this.deleteIndex = deleteIndex - 1;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = TaskList.tasks.get(deleteIndex);
        ui.addLine("Noted. I've removed this task:");
        ui.addLine("  " + t.toString());
        TaskList.tasks.remove(t);
        ui.addLine(String.format("Now you have %d tasks in the list.",TaskList.getTotalTasks()));
        ui.giveReply();
    }

}

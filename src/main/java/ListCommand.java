class ListCommand extends Command {
    ListCommand() {
    }

    void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.addLine("Here are the tasks in your list:");
        for (Task t: TaskList.tasks) {
            ui.addLine(t.toString());
        }
        ui.giveReply();
    }
}

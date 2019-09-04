import java.util.ArrayList;

class findCommand extends Command {
    private String keywords;
    findCommand(String keywords) {
        this.keywords = keywords;
    }
    void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<String> foundTasks = new ArrayList<>();
        for (Task t: TaskList.tasks) {
            if (t.description.contains(keywords)) {
                foundTasks.add(t.toString());
            }
        }
        if (foundTasks.isEmpty()) {
            ui.addLine("No task descriptions with such keywords were found.");
        } else {
            foundTasks.add(0,"Here are the matching tasks in your list:");
            for (String s: foundTasks) {
                ui.addLine(s);
            }
        }
        ui.giveReply();
    }
}

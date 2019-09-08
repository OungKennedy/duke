import java.io.IOException;

class ByeCommand extends Command {

    ByeCommand() {
        isExit = true;
    }

    void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.addLine("See you soon!");
        try {
            storage.save();
        } catch (IOException e) {
            e.getMessage();
        }
        ui.giveReply();
    }
}

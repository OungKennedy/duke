import java.io.IOException;

public abstract class Command {
    boolean isExit;

    Command() {
    }

    void execute(TaskList tasks, Ui ui, Storage storage) throws Exception {
    }

}

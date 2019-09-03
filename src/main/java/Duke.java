import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke extends Application {
    public static Ui ui;
    public static TaskList tasks;
    private static Storage storage;

    private Duke(String filePath) throws FileNotFoundException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (InvalidTaskTypeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    private static void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                // print open border of duke response
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit;
            } catch (InvalidDataException | InvalidTaskTypeException | IOException e) {
                ui.addLine(e.getMessage());
            } finally {
                // print close border of duke response
                ui.showLine();
            }
        }
        System.exit(1);
    }

    /**
     * this is the main function for duke.
     */
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\oungk\\OneDrive\\Documents\\School Work\\CS2113\\duke\\data\\duke.txt";
        new Duke(filePath);
        run();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}





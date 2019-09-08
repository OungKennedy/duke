import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Storage {
    private String filePath;
    private Scanner in;

    Storage(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        in = new Scanner(new FileReader(filePath));
    }

    ArrayList<Task> load() throws InvalidTaskTypeException {
        ArrayList<Task> tempTaskArray = new ArrayList<>();
        while (in.hasNext()) {
            String newLine = in.nextLine();
            try {
                LoadCommand c = new LoadCommand(Parser.getTaskDetailsFromSave(newLine));
                c.execute(tempTaskArray);
            } catch (InvalidTaskTypeException e) {
                e.getMessage();
            }
        }
        return tempTaskArray;
    }
    /**
     * Function to save task information to file.
     * @throws IOException : invalid input/ output?
     */

    void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath));
        for (Task task : TaskList.tasks) {
            String taskSaveData = task.toSaveData();
            writer.write(taskSaveData);
            writer.newLine();
        }
        writer.close();
    }
}

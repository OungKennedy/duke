import java.util.Calendar;

public abstract class Task {
    String description;
    boolean isDone;
    private static int totalTasks = 0; // should do something with this.

    public enum Tasktype {
        DEADLINE,
        EVENT,
        TODO
    }

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? '[' + "\u2713" + ']' : '[' + "\u2718" + ']'); // Return tick or X symbol.
    }

    public abstract String toSaveData();

    /**
     * function that forms response string for "list" command.
     * @return String containing one sentence description of Task along with status icon.
     */
    public String toString() {
        return getStatusIcon() + " " + description;
    }

    void markAsDone() {
        this.isDone = true;
    }

    /** Function to change the calendar time to a version accepted when adding tasks.
     * For save to file function.
     * @param time Calendar object containing the deadline of this task
     * @return String containing the time in the format dd/mm/yyyy HHMM (military time)
     */
    String toSaveTime(Calendar time) {
        return time.DAY_OF_MONTH + "/" + time.MONTH + "/" + time.YEAR + " " + time.HOUR_OF_DAY + time.MINUTE;
    }
}

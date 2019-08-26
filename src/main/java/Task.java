public abstract class Task {
    protected String description;
    protected boolean isDone;
    private static int totalTasks = 0; // should do something with this.

    public enum Tasktype {
        DEADLINE,
        EVENT,
        TODO
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    String getStatusIcon() {
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

}

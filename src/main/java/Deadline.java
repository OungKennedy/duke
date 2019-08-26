public class Deadline extends Task {
    protected String by;

    Tasktype tasktype = Tasktype.DEADLINE;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toSaveData() {
        return "[D]|" + String.format(isDone ? "1" : "0") + "|" + description + "|" + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}

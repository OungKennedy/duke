public class Todo extends Task {

    Tasktype tasktype = Tasktype.TODO;

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toSaveData() {
        return "[T]|" + String.format(isDone ? "1" : "0") + "|" + description + "|";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

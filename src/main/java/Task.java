class Task {
    String description;
    private boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    String getStatusIcon() {
        return (isDone ? '[' + "\u2713" + ']' : '[' + "\u2718" + ']'); // Return tick or X symbol.
    }

    void markAsDone() {
        this.isDone = true;
    }
}

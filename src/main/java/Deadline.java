import java.util.Calendar;

public class Deadline extends Task {
    private Calendar by;
    Tasktype tasktype = Tasktype.DEADLINE;

    Deadline(String description, String by) {
        super(description);
        Calendar calendar = Calendar.getInstance();
        try {
            // get day and month of by string. remaining year and time values are in last element
            String[] dateTime = by.split("[/ ]", 4);
            // get year and time of by string.
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateTime[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(dateTime[1]));
            calendar.set(Calendar.YEAR, Integer.parseInt(dateTime[2]));
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateTime[3]));
            this.by = calendar;

        } catch (Exception ex) {
            System.out.println("Error setting date for deadline: " + description + "at time " + by);
        }
    }

    @Override
    public String toSaveData() {
        return "[D]|" + (isDone ? "1" : "0") + "|" + description + "|" + toSaveTime(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.getTime() + ")";
    }
}

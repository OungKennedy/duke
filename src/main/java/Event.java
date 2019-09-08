import java.util.Calendar;

public class Event extends Task {
    private Calendar at;
    private String timeSaveString;

    Tasktype tasktype = Tasktype.EVENT;

    Event(String description, String at) {
        super(description);
        this.timeSaveString = at;
        Calendar calendar = Calendar.getInstance();
        // get details of string in array. arranged by day|month|year|military time
        try {
            String[] dateTime = at.split("[/ ]", 4);
            calendar.set(Calendar.DATE, Integer.parseInt(dateTime[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(dateTime[1]) - 1);
            // minus 1 as month is 0-indexed.
            calendar.set(Calendar.YEAR, Integer.parseInt(dateTime[2]));
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateTime[3].substring(0, 2)));
            // set with the first 2 elements - the hour
            calendar.set(Calendar.MINUTE, Integer.parseInt(dateTime[3].substring(2, 4)));
            // set with the last 2 elements, the minutes
            // clear seconds in the calendar.
            calendar.set(Calendar.SECOND, 0);
            this.at = calendar;
        } catch (Exception ex) {
            System.out.println("Error setting date for event: " + description + "at time " + at);
        }
    }

    @Override
    public String toSaveData() {
        return "[E]|" + (isDone ? "1" : "0") + "|" + description + "|" + timeSaveString;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.getTime() + ")";
    }
}

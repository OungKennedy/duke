import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {
    private Deadline testDeadline = new Deadline("This is a test","02/10/1997 1900");
    @Test
    void toSaveData() {
        String actual = "[D]|0|This is a test.|02/10/1997 1900";
        assert actual.equals(testDeadline.toSaveData());
    }

    @Test
    void testToString() {
        String actual = "[D][✘] This is a test. (at: Thu Oct 02 19:00:00 SGT 1997)";
        assert actual.equals(testDeadline.toSaveData());
    }
}
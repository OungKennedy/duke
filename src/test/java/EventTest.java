import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    private Event testEvent = new Event("This is a test.", "02/10/1997 1900");

    @Test
    void toSaveData() {
        String actual = "[E]|0|This is a test.|02/10/1997 1900";
        assert actual.equals(testEvent.toSaveData());
    }

    @Test
    void testToString() {
        String actual = "[E][✘] This is a test. (at: Thu Oct 02 19:00:00 SGT 1997)";
        assert actual.equals(testEvent.toString());
    }
}
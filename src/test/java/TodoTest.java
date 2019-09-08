import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    Todo testTodo = new Todo("This is a test");
    @Test
    void toSaveData() {
        String actual = "[T]|0|This is a test.|";
        assert actual.equals(testTodo.toSaveData());
    }

    @Test
    void testToString() {
        String actual = "[T][✘] This is a test.)";
        assert actual.equals(testTodo.toSaveData());
    }
}
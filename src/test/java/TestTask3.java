import static org.junit.jupiter.api.Assertions.*;

public class TestTask3 {
    @org.junit.jupiter.api.Test
    void testDigitalRoot() {
        assertEquals(7, Task3.digitalRoot(16));
        assertEquals(6, Task3.digitalRoot(942));
        assertEquals(6, Task3.digitalRoot(132189));
        assertEquals(2, Task3.digitalRoot(493193));
    }
}
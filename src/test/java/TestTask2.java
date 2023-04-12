import static org.junit.jupiter.api.Assertions.*;

public class TestTask2 {
    @org.junit.jupiter.api.Test
    void testFirstNonRepeatingLetter() {
        assertEquals('t', Task2.firstNonRepeatingLetter("Stress"));
        assertEquals('T', Task2.firstNonRepeatingLetter("STRess"));
        assertEquals(' ', Task2.firstNonRepeatingLetter(" "));
        assertEquals(' ', Task2.firstNonRepeatingLetter(null));
        assertEquals(' ', Task2.firstNonRepeatingLetter("sssss"));
        assertEquals('s', Task2.firstNonRepeatingLetter("aaaaaaas"));
        assertEquals('S', Task2.firstNonRepeatingLetter("Stred"));
    }
}
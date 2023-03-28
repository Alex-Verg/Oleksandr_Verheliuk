import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TasksTest {

    @org.junit.jupiter.api.Test
    void testGetIntegersFromList() {
        assertEquals(List.of(1, 2), Tasks.getIntegersFromList(List.of(1, 2, 'a', 'b')));
        assertEquals(List.of(), Tasks.getIntegersFromList(List.of('a', 'b')));
        assertEquals(List.of(1, 2, 0, 15), Tasks.getIntegersFromList(List.of(1, 2, 'a', 'b', 0, 15)));
        assertEquals(List.of(1, 2, 231), Tasks.getIntegersFromList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231)));
        assertEquals(List.of(), Tasks.getIntegersFromList(List.of()));
        assertEquals(List.of(1, 2, 3, 4), Tasks.getIntegersFromList(List.of(1, 2, 3, 4)));
    }

    @org.junit.jupiter.api.Test
    void testFirstNonRepeatingLetter() {
        assertEquals('t', Tasks.firstNonRepeatingLetter("Stress"));
        assertEquals('T', Tasks.firstNonRepeatingLetter("STRess"));
        assertEquals(' ', Tasks.firstNonRepeatingLetter(" "));
        assertEquals(' ', Tasks.firstNonRepeatingLetter(null));
        assertEquals(' ', Tasks.firstNonRepeatingLetter("sssss"));
        assertEquals('s', Tasks.firstNonRepeatingLetter("aaaaaaas"));
        assertEquals('S', Tasks.firstNonRepeatingLetter("Stred"));
    }

    @org.junit.jupiter.api.Test
    void testDigitalRoot() {
        assertEquals(7, Tasks.digitalRoot(16));
        assertEquals(6, Tasks.digitalRoot(942));
        assertEquals(6, Tasks.digitalRoot(132189));
        assertEquals(2, Tasks.digitalRoot(493193));
    }

    @org.junit.jupiter.api.Test
    void testCountPairsFor() {
        assertEquals(4, Tasks.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 5));
        assertEquals(1, Tasks.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 1));
        assertEquals(3, Tasks.countPairsFor(new int[] {2, 2, 2}, 4));
    }

    @org.junit.jupiter.api.Test
    void testCountPairsStream() {
        assertEquals(4, Tasks.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 5));
        assertEquals(1, Tasks.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 1));
        assertEquals(3, Tasks.countPairsFor(new int[] {2, 2, 2}, 4));
    }

    @org.junit.jupiter.api.Test
    void testMeeting() {
        assertEquals("(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)",
                Tasks.meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
        assertEquals("(TORNBULL, BJON)",
                Tasks.meeting("Bjon:Tornbull"));
        assertEquals("(CORWILL, ALFRED)(CORWILL, ALFRED)(CORWILL, ALFRED)",
                Tasks.meeting("Alfred:Corwill;Alfred:Corwill;Alfred:Corwill"));
        assertEquals("",
                Tasks.meeting(""));
    }

    @org.junit.jupiter.api.Test
    void testGetIp() {
        assertEquals("128.32.10.1", Tasks.getIp(2149583361L));
        assertEquals("0.0.0.32", Tasks.getIp(32L));
        assertEquals("0.0.0.0", Tasks.getIp(0L));
        assertEquals("128.0.0.0", Tasks.getIp(2147483648L));
    }
}
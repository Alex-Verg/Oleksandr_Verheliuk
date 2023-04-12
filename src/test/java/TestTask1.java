import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestTask1 {
    @org.junit.jupiter.api.Test
    void testGetIntegersFromList() {
        assertEquals(List.of(1, 2), Task1.getIntegersFromList(List.of(1, 2, 'a', 'b')));
        assertEquals(List.of(), Task1.getIntegersFromList(List.of('a', 'b')));
        assertEquals(List.of(1, 2, 0, 15), Task1.getIntegersFromList(List.of(1, 2, 'a', 'b', 0, 15)));
        assertEquals(List.of(1, 2, 231), Task1.getIntegersFromList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231)));
        assertEquals(List.of(), Task1.getIntegersFromList(List.of()));
        assertEquals(List.of(1, 2, 3, 4), Task1.getIntegersFromList(List.of(1, 2, 3, 4)));
    }
}
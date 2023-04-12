import static org.junit.jupiter.api.Assertions.*;

public class TestTask4 {
    @org.junit.jupiter.api.Test
    void testCountPairsFor() {
        assertEquals(4, Task4.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 5));
        assertEquals(1, Task4.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 1));
        assertEquals(3, Task4.countPairsFor(new int[] {2, 2, 2}, 4));
    }

    @org.junit.jupiter.api.Test
    void testCountPairsStream() {
        assertEquals(4, Task4.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 5));
        assertEquals(1, Task4.countPairsFor(new int[] {1, 3, 6, 2, 2, 0, 4, 5}, 1));
        assertEquals(3, Task4.countPairsFor(new int[] {2, 2, 2}, 4));
    }
}
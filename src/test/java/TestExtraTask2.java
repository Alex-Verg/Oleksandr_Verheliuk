import static org.junit.jupiter.api.Assertions.*;

public class TestExtraTask2 {
    @org.junit.jupiter.api.Test
    void testGetIp() {
        assertEquals("128.32.10.1", ExtraTask2.getIp(2149583361L));
        assertEquals("0.0.0.32", ExtraTask2.getIp(32L));
        assertEquals("0.0.0.0", ExtraTask2.getIp(0L));
        assertEquals("128.0.0.0", ExtraTask2.getIp(2147483648L));
    }
}
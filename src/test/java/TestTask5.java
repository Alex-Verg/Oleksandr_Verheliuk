import static org.junit.jupiter.api.Assertions.*;

public class TestTask5 {
    @org.junit.jupiter.api.Test
    void testMeeting() {
        assertEquals("(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)",
                Task5.meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
        assertEquals("(TORNBULL, BJON)",
                Task5.meeting("Bjon:Tornbull"));
        assertEquals("(CORWILL, ALFRED)(CORWILL, ALFRED)(CORWILL, ALFRED)",
                Task5.meeting("Alfred:Corwill;Alfred:Corwill;Alfred:Corwill"));
        assertEquals("",
                Task5.meeting(""));
    }
}
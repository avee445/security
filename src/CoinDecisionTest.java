
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoinDecisionTest {

    CoinDecision cd = new CoinDecision();

    // בדיקה: 0 פעמים H -> תוצאה Negative
    @Test
    public void testZeroHeads() {
        String result = cd.CoinDecision("T", "T", "T", "T");
        assertEquals("Negative", result);
    }

    // בדיקה: פעם אחת H -> תוצאה Negative
    @Test
    public void testOneHead() {
        String result = cd.CoinDecision("H", "T", "T", "T");
        assertEquals("Negative", result);
    }

    // בדיקה: פעמיים H -> תוצאה Positive (ערך הגבול למעבר לחיובי)
    @Test
    public void testTwoHeads() {
        String result = cd.CoinDecision("H", "H", "T", "T");
        assertEquals("Positive", result);
    }

    // בדיקה: שלוש פעמים H -> תוצאה Positive
    @Test
    public void testThreeHeads() {
        String result = cd.CoinDecision("H", "H", "H", "T");
        assertEquals("Positive", result);
    }

    // בדיקה: ארבע פעמים H -> תוצאה Positive
    @Test
    public void testFourHeads() {
        String result = cd.CoinDecision("H", "H", "H", "H");
        assertEquals("Positive", result);
    }
}
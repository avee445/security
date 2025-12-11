import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegrationABTest {

    // Stub לסיום השרשרת
    class StubC extends C {
        @Override
        public String process(String input) {
            return input + "L";
        }
    }

    @Test
    public void testIntegrationAandB() {
        A a = new A();
        B b = new B(); // ה-B הזה מכיל את הבאג
        StubC stubC = new StubC();

        // חיבור: A -> B -> StubC
        a.setNext(b);
        b.setNext(stubC);

        String result = a.process("");

        // A מוסיף H, מעביר ל-B
        // B מוסיף E, מעביר ל-C (אמור לקבל L)
        // צפוי: "HEL"
        // בפועל (בגלל הבאג): "HE" -> הטסט ייכשל
        assertEquals("HEL", result);
    }
}
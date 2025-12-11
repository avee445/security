import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BUnitTest {

    // Stub שמדמה את C לצורך הבדיקה של B
    // מכיוון שאנחנו באותה תיקייה (default package), המערכת מכירה את המממשק/מחלקה C
    class StubC extends C {
        @Override
        public String process(String input) {
            return input + "L";
        }
    }

    // טסט 1: לא מגלה את התקלה (Green)
    // בודק רק את הפעולה המקומית של B (הוספת E)
    @Test
    public void testThatMissesTheBug() {
        B b = new B();
        b.setNext(new StubC());

        String result = b.process("Start");

        // הבדיקה עוברת כי B מחזיר מחרוזת שמסתיימת ב-"E" גם כשיש באג
        assertTrue(result.endsWith("E"), "Result should end with E");
    }

    // טסט 2: מגלה את התקלה (Red)
    // בודק שהשרשרת המשיכה ל-C ושקיבלנו את ה-"L"
    @Test
    public void testThatRevealsTheBug() {
        B b = new B();
        b.setNext(new StubC()); // StubC מוסיף "L"

        String result = b.process("Start");

        // הציפייה: "StartEL" (ה-E של B וה-L של C)
        // בפועל נקבל: "StartE" (בגלל הבאג ב-B) -> והטסט ייכשל
        assertEquals("StartEL", result, "B failed to include result from C");
    }
}
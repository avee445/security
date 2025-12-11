import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// 🔹 מחלקות המערכת

class E {
    public String process(String input) {
        return input + "O";
    }
}

class D {
    private E next;
    public void setNext(E next) {
        this.next = next;
    }
    public String process(String input) {
        return next.process(input + "L");
    }
}

class C {
    private D next;
    public void setNext(D next) {
        this.next = next;
    }
    public String process(String input) {
        return next.process(input + "L");
    }
}


class B {
    private C next;

    public void setNext(C next) {
        this.next = next;
    }

    public String process(String input) {
        // --- התקלה המכוונת ---
        // שולחים את הקלט לחוליה הבאה (C) אבל מתעלמים מהתוצאה (update)
        String update = next.process(input + "E");

        // מחזירים רק את העיבוד המקומי וקוטעים את השרשרת
        return input + "E";
    }
}

class A {
    private B next;
    public void setNext(B next) {
        this.next = next;
    }
    public String process(String input) {
        return next.process(input + "H");
    }
}

// 🔹 Stubs לבדיקה

class StubC extends C {
    @Override
    public String process(String input) {
        return input + "L"; // מדמה את הפעולה של C
    }
}

class StubD extends D {
    @Override
    public String process(String input) {
        return input + "L"; // מדמה את הפעולה של D
    }
}

class StubE extends E {
    @Override
    public String process(String input) {
        return input + "O"; // מדמה את הפעולה של E
    }
}

// 🔹 בדיקות JUnit

public class ChainTest {

    // בדיקות יחידה
    @Test
    public void testUnit_B() {
        B b = new B();
        b.setNext(new StubC());
        String result = b.process("H");
        assertEquals("HEL", result);
    }

    @Test
    public void testUnit_D() {
        D d = new D();
        d.setNext(new StubE());
        String result = d.process("HEL");
        assertEquals("HELLO", result);
    }

    // בדיקות אינטגרציה
    @Test
    public void testIntegration_AtoB() {
        A a = new A();
        B b = new B();
        b.setNext(new StubC());
        a.setNext(b);
        String result = a.process("");
        assertEquals("HEL", result);
    }

    @Test
    public void testIntegration_CtoD() {
        C c = new C();
        D d = new D();
        d.setNext(new StubE());
        c.setNext(d);
        String result = c.process("HE");
        assertEquals("HELLO", result);
    }

    // בדיקות מערכת
    @Test
    public void testSystem_FullChain() {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        String result = a.process("");
        assertEquals("HELLO", result);
    }

    @Test
    public void testInvalidInput() {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        String result = a.process("X");
        assertNotEquals("HELLO", result);
    }

    @Test
    public void testPartialInput() {
        C c = new C();
        D d = new D();
        E e = new E();

        c.setNext(d);
        d.setNext(e);

        String result = c.process("HE");
        assertEquals("HELLO", result);
    }
}
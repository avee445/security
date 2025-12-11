



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinCalculatorTest {

    // --- בדיקות שליליות (חריגה מטווח) ---

    // מקרה בדיקה: ערך מתחת למינימום (0) -> מצופה שגיאה
    @Test
    public void testBelowMinimum_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            MinCalculator.findMin(0, 500, 500, 500, 500);
        });
    }

    // מקרה בדיקה: ערך מעל המקסימום (1001) -> מצופה שגיאה
    @Test
    public void testAboveMaximum_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            MinCalculator.findMin(1001, 500, 500, 500, 500);
        });
    }

    // --- בדיקות חיוביות (ערכי גבול וערכים תקינים) ---

    // מקרה בדיקה: גבול תחתון (1)
    @Test
    public void testBoundaryMin_Value1() {
        int result = MinCalculator.findMin(1, 500, 500, 500, 500);
        assertEquals(1, result);
    }

    // מקרה בדיקה: מעל גבול תחתון (2)
    @Test
    public void testBoundaryMinPlusOne_Value2() {
        int result = MinCalculator.findMin(2, 500, 500, 500, 500);
        assertEquals(2, result);
    }

    // מקרה בדיקה: ערך נומינלי (אמצע הטווח)
    @Test
    public void testNominal_Value500() {
        int result = MinCalculator.findMin(500, 500, 500, 500, 500);
        assertEquals(500, result);
    }

    // מקרה בדיקה: מתחת לגבול עליון (999)
    @Test
    public void testBoundaryMaxMinusOne_Value999() {
        // המינימום הוא 500 (כי שאר המספרים הם 500), אך הפונקציה צריכה לעבוד
        int result = MinCalculator.findMin(999, 500, 500, 500, 500);
        assertEquals(500, result);
    }

    // מקרה בדיקה: גבול עליון (1000)
    @Test
    public void testBoundaryMax_Value1000() {
        int result = MinCalculator.findMin(1000, 500, 500, 500, 500);
        assertEquals(500, result);
    }
}
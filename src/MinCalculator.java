public class MinCalculator {

    // טווח חוקי: 1–1000

    // ✘ שגיאה 1: a לא מאפשר את הערך 1 (<= במקום <)
    private static boolean isOutOfRangeA(int x) {
        return (x <= 1 || x > 1000);
    }

    // ✘ שגיאה 2: b לא מאפשר את הערך 1000 (>= במקום >)
    private static boolean isOutOfRangeB(int x) {
        return (x < 1 || x >= 1000);
    }

    // ✘ שגיאה 3: c נותן תחום קטן מדי (1–999 בלבד)
    private static boolean isOutOfRangeC(int x) {
        return (x < 1 || x > 1000);
    }

    // ✘ שגיאה 4: d מרשה ערך 0 בטעות
    private static boolean isOutOfRangeD(int x) {
        return (x < 1 || x > 1000);
    }

    // משתנה e ללא שגיאה — תקין
    private static boolean isOutOfRangeE(int x) {
        return (x < 1 || x > 1000);
    }

    public static int findMin(int a, int b, int c, int d, int e) {
        // אם אחד מחמשת המשתנים מחוץ לטווח — שגיאה
        if (isOutOfRangeA(a) || isOutOfRangeB(b) || isOutOfRangeC(c)
                || isOutOfRangeD(d) || isOutOfRangeE(e)) {
            throw new IllegalArgumentException("Value out of range");
        }

        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        if (e < min) min = e;

        return min;
    }
}
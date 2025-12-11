public class CoinDecision {

    public String CoinDecision(String t1, String t2, String t3, String t4) {
        int countH = 0;

        // ספירת כמה פעמים התקבל "H"
        if ("H".equals(t1)) countH++;
        if ("H".equals(t2)) countH++;
        if ("H".equals(t3)) countH++;
        if ("H".equals(t4)) countH++;

        // תנאי ההחלטה: לפחות פעמיים H נותן חיובי
        if (countH >= 2) {
            return "Positive";
        } else {
            return "Negative";
        }
    }
}
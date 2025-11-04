public class L343_2 {
    public static void main(String[] args) {
        L343 l343 = new L343();
        for (int i = 2; i < 58; i++) {
            System.out.println(l343.integerBreak(i));
        }
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }

}

public class Z1 {
    public static void main(String[] args) {
        ClassLoader
        int n = 7;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        // int[] dp = new int[n];
        // dp[0] = 1;
        // for (int i = 1; i < dp.length; i++) {
        // if (dp[i - 1] % arr[i] != 0) {
        // dp[i] = dp[i - 1] * arr[i];
        // }else{
        // dp[i] = dp[i - 1];
        // }
        // }
        // System.out.println(dp[dp.length - 1]);

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == 1) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == 1) {
                    continue;
                }
                if (arr[j] % arr[i] == 0) {
                    arr[j] = 1;
                }
            }
        }

        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            ans *= arr[i];
        }
        System.out.println(ans);
    }
}

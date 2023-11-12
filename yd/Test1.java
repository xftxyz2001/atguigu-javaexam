
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + Math.abs(arr[i][j] - arr[i][j - 1]);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + Math.abs(arr[i][j] - arr[i - 1][j]);
                } else {
                    int up = dp[i - 1][j] + Math.abs(arr[i][j] - arr[i - 1][j]);
                    int left = dp[i][j - 1] + Math.abs(arr[i][j] - arr[i][j - 1]);
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(dp[N - 1][N - 1]);
    }
}
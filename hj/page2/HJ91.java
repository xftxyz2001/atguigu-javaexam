import java.util.Scanner;

public class HJ91 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[x][y]);
    }
}

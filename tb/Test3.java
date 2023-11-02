import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 行
        int m = in.nextInt(); // 列

        // String[] rows = new String[n];
        char[][] charArray = new char[n][m];
        for (int i = 0; i < n; i++) {
            // rows[i] = in.next();
            String s = in.next();
            charArray[i] = s.toCharArray();
        }
        in.close();

        System.out.println(func(charArray));

    }

    private static int func(char[][] charArray) {
        final int MOD = 1_000_000_007;
        // charArray[i][j] = 'W' or 'R' or ?; 共有2^k上色可能k为?数量，问所有上色情况
        // RR
        // RR
        // 出现的次数
        int count = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = 0; j < charArray[i].length - 1; j++) {
                if (charArray[i][j] != 'W' &&
                        charArray[i][j + 1] != 'W' &&
                        charArray[i + 1][j] != 'W' &&
                        charArray[i + 1][j + 1] != 'W') {
                    count++;
                }
            }
        }

        return count % MOD;
    }
}
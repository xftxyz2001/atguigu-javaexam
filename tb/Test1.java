import java.util.Scanner;
import java.util.Arrays;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 糖果的种类

        int[][] ab = new int[n][2]; // 0打折需要的个数, 1需要购买的个数
        for (int i = 0; i < n; i++) {
            ab[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ab[i][1] = in.nextInt();
        }
        in.close();
        Arrays.sort(ab, (a1, a2) -> a2[0] - a1[0]); // 降序？

        int sum = 0; // 总花费
        int m = 0; // 购买的个数
        int d = ab.length - 1;
        for (int i = 0; i <= d; i++) {
            while (ab[i][1] > 0) {
                // 购买
                m++;
                sum += 2;
                ab[i][1]--;
                if (m > ab[d][0]) { // 有新的打折存在
                    // 打折
                    while (ab[d][1] > 0) {
                        m++;
                        sum++; // 低价购买
                        ab[d][1]--;
                    }
                    d--;
                }

            }

        }
        System.out.println(sum);

    }
}
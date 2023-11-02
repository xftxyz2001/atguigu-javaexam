import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 宝塔中宝藏的个数
        int[] a = new int[n]; // 宝藏的价值
        int[] b = new int[n]; // 每天可以拿出的最低价值

        // 初始化数组
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(a);
        int an = a.length;
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            // b[i] min
            int minGtBiIndex = -1;
            // for (int j = 0; j < a.length; j++) {
            // if (a[j] < 0) {
            // continue;
            // }
            // // 找到可以拿出来的
            // if (a[j] >= b[i]) {
            // // 之前没有
            // if (minGtBiIndex == -1) {
            // minGtBiIndex = j;
            // } else {
            // int min = Math.min(a[j], a[minGtBiIndex]);
            // if (min != a[minGtBiIndex]) {
            // minGtBiIndex = j;
            // }
            // }
            // }
            // }
            for (int j = 0; j < an; j++) {
                // 找到可以拿出来的
                if (a[j] >= b[i]) {
                    minGtBiIndex = j;
                    break;
                }

            }
            // 找到了
            if (minGtBiIndex != -1) {
                // 已经被拿出
                // a[minGtBiIndex] = -1;
                for (int j = minGtBiIndex; j + 1 < an; j++) {
                    a[j] = a[j + 1];
                }
                an--;
                count++;
            }
        }
        System.out.println(count);
    }
}

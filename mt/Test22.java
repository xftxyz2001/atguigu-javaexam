import java.util.Scanner;

public class Test22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 宝塔中宝藏的个数
        // int[] a = new int[n]; // 宝藏的价值
        int[] ac = new int[100001]; // 1-100000 // i价值宝藏的个数
        // int[] b = new int[n]; // 每天可以拿出的最低价值

        // 初始化数组
        for (int i = 0; i < n; i++) {
            int ai = sc.nextInt();
            ac[ai]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int bi = sc.nextInt();
            // ac[i]：价值i的宝藏
            for (int j = bi; j < ac.length; j++) {
                if (ac[j] > 0) {
                    ac[j]--;
                    count++;
                }
            }
        }
        sc.close();
        System.out.println(count);
    }
}

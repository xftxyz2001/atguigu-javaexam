import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int V = scanner.nextInt();

        int[][] nums = new int[V][H];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < H; j++) {
                nums[i][j] = i * H + j;
            }
        }

        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int id = scanner.nextInt();
            // 位置
            int v = id / H;
            int h = id % H;
            // 上
            System.out.print(nums[v - 1 < 0 ? V - 1 : v - 1][h] + " ");
            // 左
            if (h - 1 >= 0) {
                System.out.print(nums[v][h - 1] + " ");
            }
            // 下
            System.out.print(nums[v + 1 >= V ? 0 : v + 1][h] + " ");
            // 右
            if (h + 1 < H) {
                System.out.print(nums[v][h + 1] + " ");
            }
            // 自己
            System.out.println(id);
        }
        scanner.close();
    }
}
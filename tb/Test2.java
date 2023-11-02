import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int[][] arr = new int[n][n];
        int num = 1; // 当前地板砖编号

        int row = n / 2 - 1;
        int col = n / 2 - 1;

        for (int lay = 1; lay <= n / 2; lay++) { // 从内向外第n层
            // System.out.println(row+" "+col);
            // →
            for (int i = 0; i < lay; i++) {
                arr[row][col++] = num;
                arr[row][col++] = num;
                num++;
            }
            // ↓
            for (int i = 0; i < lay; i++) {
                arr[row++][col] = num;
                arr[row++][col] = num;
                num++;
            }
            // ←
            for (int i = 0; i < lay; i++) {
                arr[row][col--] = num;
                arr[row][col--] = num;
                num++;
            }
            // ↑
            for (int i = 0; i < lay; i++) {
                arr[row--][col] = num;
                arr[row--][col] = num;
                num++;
            }
            row--;
            col--; // 向左上角移动以进行下一次
        }
        for (int[] a : arr) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
                if (i < a.length - 1) { // 不是最后一个
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
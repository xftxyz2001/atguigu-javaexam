import java.util.Scanner;

public class HJ35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int cnt = 1;
        int row = 0;
        int Row = 0;
        int col = 0;
        int[][] arr = new int[n][n];
        while (true) {
            arr[row--][col++] = cnt++;
            if (row < 0) {
                row = ++Row;
                col = 0;
            }
            if (row >= n) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(arr[i][j]);
                if (j != n - i - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

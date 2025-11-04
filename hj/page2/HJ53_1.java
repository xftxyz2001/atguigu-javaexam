// OOM
import java.util.Scanner;

public class HJ53_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int[][] arr = new int[n][2 * n - 1];
        arr[0][(2 * n - 1) / 2] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[i - 1][j];
                if (j > 0) {
                    arr[i][j] += arr[i - 1][j - 1];
                }
                if (j < arr[i].length - 1) {
                    arr[i][j] += arr[i - 1][j + 1];
                }
            }
        }
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        int index = -1;
        for (int i = 0; i < arr[arr.length - 1].length; i++) {
            if (arr[arr.length - 1][i] % 2 == 0) {
                index = i + 1;
                break;
            }
        }
        System.out.println(index);
    }
}

// !!!
import java.util.Scanner;

public class HJ61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.close();

        System.out.println(getWay(m, n));
    }

    private static int getWay(int m, int n) {
        if (n == 1) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i <= m; i++) {
            cnt += getWay(m - i, n - 1);
        }
        return cnt;
    }
}

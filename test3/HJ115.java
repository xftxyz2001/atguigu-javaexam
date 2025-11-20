import java.util.Scanner;

public class HJ115 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        in.close();

        for (int i = 1; i <= 2 * x;) {
            int cnt = count(i, i + k - 1, x);
            if (cnt == n) {
                System.out.println(x + " " + (x + k - 1));
                return;
            } else if (cnt > n) {
                if (i==1) {
                    i = x;
                } else {
                    i += x;
                }
            }
        }
        System.out.println(-1);
    }

    private static int count(int begin, int end, int x) {
        int cnt = 0;
        for (int i = begin; i <= end; i++) {
            if (i % x == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}

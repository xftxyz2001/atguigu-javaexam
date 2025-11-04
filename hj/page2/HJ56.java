import java.util.Scanner;

public class HJ56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        // 6 28 496 8128
        int cnt = 0;
        for (int i = 6; i <= n; i++) {
            if (isFull(i)) {
                cnt++;
                // System.out.println(i);
            }
        }
        System.out.println(cnt);
    }

    private static boolean isFull(int num) {
        int res = 1;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        return res == num;
    }

}

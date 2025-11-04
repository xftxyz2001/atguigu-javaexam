import java.util.Scanner;

public class HJ99 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        // 0 1 5 6 25 76 376 625 9376
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (check(i)) {
                // System.out.println(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int num) {
        return Integer.toString(num * num).endsWith(String.valueOf(num));
    }
}

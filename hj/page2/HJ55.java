import java.util.Scanner;

public class HJ55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (severn(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean severn(int num) {
        if (num % 7 == 0) {
            return true;
        }
        while (num != 0) {
            if (num % 10 == 7) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}

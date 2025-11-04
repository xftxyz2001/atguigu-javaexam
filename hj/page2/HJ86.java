import java.util.Scanner;

public class HJ86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int max1 = 0;
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                cnt++;
            } else {
                if (cnt > max1) {
                    max1 = cnt;
                }
                cnt = 0;
            }
            n >>= 1;
        }
        if (cnt > max1) {
            max1 = cnt;
        }
        System.out.println(max1);
    }
}

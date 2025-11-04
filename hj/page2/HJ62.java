import java.util.Scanner;

public class HJ62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();
        // System.out.println(Integer.bitCount(n));
        // System.out.println(Integer.bitCount(m));
        System.out.println(bitCount(n));
        System.out.println(bitCount(m));
    }

    private static int bitCount(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n >>= 1;
        }
        return cnt;
    }

}

import java.util.Scanner;

public class HJ15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();

        // System.out.println(Integer.bitCount(num));
        int cnt = 0;
        for (int i = 1; i != 0; i <<= 1) {
            if ((i & num) != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
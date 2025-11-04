import java.util.Scanner;

public class HJ53_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        if (n == 1 || n == 2) {
            System.out.println(-1);
        } else if (n % 2 == 1) {
            System.out.println(2);
        } else if ((n / 2) % 2 == 0) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }
}

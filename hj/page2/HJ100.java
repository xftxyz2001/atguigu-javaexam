import java.util.Scanner;

public class HJ100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        System.out.println((2 + (2 + 3 * (n - 1))) * n / 2);
    }
}

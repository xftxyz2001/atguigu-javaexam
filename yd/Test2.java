
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        long total = 0;
        int boxes = Math.min(n / a, m / b);
        total += (long) boxes * x;
        n -= boxes * a;
        m -= boxes * b;

        boxes = m / c;
        total += (long) boxes * y;
        m -= boxes * c;

        boxes = n / d;
        total += (long) boxes * z;

        System.out.println(total);

        scanner.close();
    }
}

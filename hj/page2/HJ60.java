import java.util.Scanner;

public class HJ60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int min = n / 2;
        int max = n - min;
        while (min >= 2 & max <= n - 2) {
            if (isPrime(min) && isPrime(max)) {
                break;
            }
            min--;
            max++;
        }
        System.out.println(min);
        System.out.println(max);
    }

    private static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

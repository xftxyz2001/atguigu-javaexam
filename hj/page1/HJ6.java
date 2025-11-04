// !!!超时!!!
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        in.close();

        // ArrayList<Long> primeNumList = getPrimeNumList(num);
        ArrayList<Long> resultList = new ArrayList<>();
        long n = 2;
        while (n <= num) {
            while (num % n == 0) {
                resultList.add(n);
                num /= n;
            }

            while (!isPrimeNum(++n))
                ;
        }

        // for (int i = 0; i < primeNumList.size(); i++) {
        // Long pi = primeNumList.get(i);
        // while (num % pi == 0) {
        // resultList.add(pi);
        // num /= pi;
        // if (num <= 1) {
        // break;
        // }
        // }
        // }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < resultList.size(); i++) {
            sj.add(String.valueOf(resultList.get(i)));
        }
        System.out.println(sj.toString());
    }

    // private static ArrayList<Long> getPrimeNumList(long num) {
    // ArrayList<Long> result = new ArrayList<>();
    // for (long i = 2; i <= num; i++) {
    // if (num % i == 0 && isPrimeNum(i)) {
    // result.add(i);
    // }
    // }
    // return result;
    // }

    private static boolean isPrimeNum(long num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        for (long i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

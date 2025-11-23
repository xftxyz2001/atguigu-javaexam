public class L3726 {
    public long removeZeros(long n) {
        long res = 0;
        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                res = res * 10 + digit;
            }
            n /= 10;
        }

        // reverse
        long rev = 0;
        while (res > 0) {
            long digit = res % 10;
            rev = rev * 10 + digit;
            res /= 10;
        }
        return rev;

    }
}

public class L3536 {
    public int maxProduct(int n) {
        int res = 0;
        int max = 0;
        while (n > 0) {
            int cur = n % 10;
            res = Math.max(res, cur * max);
            max = Math.max(max, cur);
            n /= 10;
        }
        return res;
    }
}

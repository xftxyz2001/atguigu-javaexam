public class L1513 {
    public int numSub(String s) {
        long num = 0;
        // int cur = 0;
        long cur = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (cur != 0) {
                    num += cur * (cur + 1) / 2;
                    num %= 1000000007;
                }
                cur = 0;
            } else {
                cur++;
            }
        }
        if (cur != 0) {
            num += cur * (cur + 1) / 2;
            num %= 1000000007;
        }
        return (int) num;
    }

}
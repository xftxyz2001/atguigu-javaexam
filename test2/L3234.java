public class L3234 {

    public int numberOfSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (valid(s.substring(i, j))) {
                    cnt++;
                }
            }
        }
        return cnt;

    }

    private boolean valid(String str) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }
        return one >= zero * zero;
    }
}
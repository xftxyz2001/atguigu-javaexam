public class L3168 {
    public int minimumChairs(String s) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur--;
            }
        }
        return max;
    }
}

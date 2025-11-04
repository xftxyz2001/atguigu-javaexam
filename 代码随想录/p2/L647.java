public class L647 {

    public static void main(String[] args) {
        System.out.println(new L647().countSubstrings("abc"));
    }

    public int countSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int res = 0;
        if (isCycle(s)) {
            res++;
        }
        res += countSubstrings(s.substring(0, s.length() - 1));
        res += countSubstrings(s.substring(1, s.length()));
        return res;
    }

    private boolean isCycle(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
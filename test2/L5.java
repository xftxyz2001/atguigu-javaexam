public class L5 {
    public String longestPalindrome(String s) {
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (substring.length() <= ss.length()) {
                    continue;
                }
                if (isPalindrome(substring)) {
                    ss = substring;
                }
            }
        }
        return ss;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
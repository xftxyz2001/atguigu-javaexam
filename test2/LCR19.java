public class LCR19 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        if (s.charAt(left + 1) == s.charAt(right)) {
            int newLeft = left + 2;
            int newRight = right - 1;
            while (newLeft < newRight) {
                if (s.charAt(newLeft) != s.charAt(newRight)) {
                    break;
                }
                newLeft++;
                newRight--;
            }
            if (newLeft >= newRight) {
                return true;
            }
        }
        if (s.charAt(left) == s.charAt(right - 1)) {
            int newLeft = left + 1;
            int newRight = right - 2;
            while (newLeft < newRight) {
                if (s.charAt(newLeft) != s.charAt(newRight)) {
                    break;
                }
                newLeft++;
                newRight--;
            }
            if (newLeft >= newRight) {
                return true;
            }
        }
        return false;
    }
}

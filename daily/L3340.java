public class L3340 {
    public boolean isBalanced(String num) {
        int odd = 0, even = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (i % 2 == 0) {
                even += digit;
            } else {
                odd += digit;
            }
        }
        return odd == even;

    }
}

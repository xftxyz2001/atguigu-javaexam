import java.math.BigInteger;

public class L402_2 {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char chi = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.charAt(stack.length() - 1) > chi) {
                stack.setLength(stack.length() - 1);
                k--;
            }
            stack.append(chi);
        }
        stack.setLength(stack.length() - k);
        return new BigInteger(stack.toString()).toString();
    }

}
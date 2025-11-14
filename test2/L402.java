import java.math.BigInteger;

public class L402 {

    // public static void main(String[] args) {
    //     new L402().removeKdigits("1432219", 3);
    // }

    BigInteger ans = null;
    StringBuilder sb = new StringBuilder();

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        int needLen = num.length() - k;
        removeKdigits0(num, 0, needLen);
        return ans.toString();
    }

    private void removeKdigits0(String num, int start, int needLen) {
        if (needLen == 0) {
            // System.out.println(sb);
            BigInteger bi = new BigInteger(sb.toString());
            if (ans == null || bi.compareTo(ans) < 0) {
                ans = bi;
            }
            return;
        }
        for (int i = start; i + needLen <= num.length(); i++) {
            char chi = num.charAt(i);
            if (chi == '0' && sb.length() == 0) {
                continue;
            }
            sb.append(chi);
            removeKdigits0(num, i + 1, needLen - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
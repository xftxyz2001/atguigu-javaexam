import java.util.ArrayList;
import java.util.List;

public class L3211 {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> validStrings(int n) {
        validStrings0(n);
        return ans;
    }

    private void validStrings0(int n) {
        if (sb.length() == n) {
            ans.add(sb.toString());
            return; // !!!
        }
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '0') {
            sb.append('0');
            validStrings0(n);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('1');
        validStrings0(n);
        sb.deleteCharAt(sb.length() - 1);
    }
}

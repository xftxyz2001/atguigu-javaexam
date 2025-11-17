import java.util.ArrayList;
import java.util.List;

public class L22 {
    List<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return ans;
    }

    public void backtrack(int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    // public List<String> generateParenthesis(int n) {
    // List<String> al = new ArrayList<>();
    // al.add("(".repeat(n) + ")".repeat(n));

    // for (int i = 1; i < n; i++) {
    // List<String> p1 = generateParenthesis(i);
    // List<String> p2 = generateParenthesis(n - i);
    // for (String p11 : p1) {
    // for (String p22 : p2) {
    // al.add(p11 + p22);
    // }
    // }
    // }
    // return al;
    // }
}

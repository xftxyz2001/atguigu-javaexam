import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class L93 {

    public static void main(String[] args) {
        System.out.println(new L93().restoreIpAddresses("25525511135"));
    }

    List<String> path = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return ans;
    }

    private void backtracking(String s, int start) {
        if (path.size() == 3) {
            String substring = s.substring(start, s.length());
            if (isValid(substring)) {
                path.add(substring);
                ans.add(toIP(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (!isValid(substring)) {
                return;
            }
            path.add(substring);
            backtracking(s, i);
            path.remove(path.size() - 1);
        }
    }

    private String toIP(List<String> path) {
        StringJoiner sj = new StringJoiner(".");
        for (String string : path) {
            sj.add(string);
        }
        return sj.toString();
    }

    private boolean isValid(String str) {
        // if (str.length() == 1) {
        // return true;
        // } else if (str.length() == 2) {
        // if (str.charAt(0) != '0') {
        // return true;
        // }
        // } else if (str.length() == 3) {
        // if (str.charAt(0) == '1') {
        // return true;
        // } else if (str.charAt(0) == '2') {
        // if (str.charAt(1) >= '0' && str.charAt(1) <= '4') {
        // return true;
        // } else if (str.charAt(1) == '5' && str.charAt(2) >= '0' && str.charAt(2) <=
        // '5') {
        // return true;
        // }
        // }
        // }
        if (str.length() == 1) {
            return true;
        } else if ((str.length() == 2 || str.length() == 3) && str.charAt(0) != '0') {
            if (Integer.parseInt(str) <= 255) {
                return true;
            }
        }
        return false;
    }
}

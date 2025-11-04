import java.util.ArrayList;
import java.util.List;

public class L131 {

    public static void main(String[] args) {

        System.out.println(new L131().partition("aab"));
    }

    List<String> path = new ArrayList<>();
    int pathStringLength = 0;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return ans;
    }

    private void backtracking(String s, int start) {
        // if (start >= s.length()) {
        //     return;
        // }
        if (pathStringLength == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (!isCycle(substring)) {
                continue;
            }
            path.add(substring);
            pathStringLength += substring.length();
            backtracking(s, i);
            path.remove(path.size() - 1);
            pathStringLength -= substring.length();
        }
    }

    private boolean isCycle(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }
}

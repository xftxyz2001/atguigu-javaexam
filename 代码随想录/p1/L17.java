import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17 {

    public static void main(String[] args) {
        new L17().letterCombinations("23");
    }

    // List<Character> path = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    List<String> ans = new ArrayList<>();
    Map<Character, char[]> map = new HashMap<>();
    {
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }

    public List<String> letterCombinations(String digits) {
        letterCombinations0(digits.toCharArray(), 0);
        return ans;
    }

    private void letterCombinations0(char[] charArray, int i) {
        if (path.length() == charArray.length) {
            ans.add(path.toString());
            return;
        }
        char[] cs = map.get(charArray[i]);
        for (int j = 0; j < cs.length; j++) {
            path.append(cs[j]);
            letterCombinations0(charArray, i + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

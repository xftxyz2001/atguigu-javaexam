import java.util.HashSet;
import java.util.Set;

public class L1593 {

    public static void main(String[] args) {
        new L1593().maxUniqueSplit("ababccc");
    }

    Set<String> set = new HashSet<>();
    int maxSize = 0;

    public int maxUniqueSplit(String s) {
        maxUniqueSplit0(s);
        return maxSize;
    }

    private void maxUniqueSplit0(String s) {
        if (s.length() == 0) {
            if (set.size() > maxSize) {
                maxSize = set.size();
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            String str0i = s.substring(0, i);
            if (set.contains(str0i)) {
                continue;
            }
            set.add(str0i);
            maxUniqueSplit0(s.substring(i, s.length()));
            set.remove(str0i);
        }
    }
}
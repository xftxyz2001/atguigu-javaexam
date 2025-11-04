import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L763_2 {
    public static void main(String[] args) {
        new L763_2().partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        // 记录字母最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char chi = s.charAt(i);
            right = Math.max(map.get(chi), right);
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}

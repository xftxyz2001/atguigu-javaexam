import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L763 {
    public static void main(String[] args) {
        new L763().partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        // 记录字母最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char chi = s.charAt(i);
            int index = map.get(chi);
            for (int j = i + 1; j < index; j++) {
                chi = s.charAt(j);
                index = Math.max(map.get(chi), index);
            }
            res.add(index - i + 1);
            // System.out.println(s.substring(i, index + 1));
            i = index;
        }
        return res;
    }
}

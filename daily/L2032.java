import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> set3 = new HashSet<>();
        for (int num : nums3) {
            set3.add(num);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : set1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : set2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : set3) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
            }
        }
        return list;

    }
}

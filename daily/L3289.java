import java.util.HashSet;
import java.util.Set;

public class L3289 {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int k = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                res[k++] = num;
                if (k == res.length) {
                    break;
                }
            }
            set.add(num);
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q23 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!hash.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}

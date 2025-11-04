import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L47 {

    public static void main(String[] args) {
        System.out.println(new L47().permuteUnique(new int[] { 1, 1, 2 }));
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteUnique0(nums, used);
        return ans;
    }

    private void permuteUnique0(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            set.add(nums[i]);
            permuteUnique0(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

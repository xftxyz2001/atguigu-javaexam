import java.util.ArrayList;
import java.util.List;

public class L78 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    private void backtracking(int[] nums, int start) {
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

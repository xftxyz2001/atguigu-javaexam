import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90 {

    public static void main(String[] args) {

        System.out.println(new L90().subsetsWithDup(new int[] { 1, 2, 2 }));
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, 0, used);
        return ans;
    }

    private void backtracking(int[] nums, int start, boolean[] used) {
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

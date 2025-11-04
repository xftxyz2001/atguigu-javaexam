import java.util.ArrayList;
import java.util.List;

public class L46 {

    public static void main(String[] args) {
        System.out.println(new L46().permute(new int[] { 1, 2 }));
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute0(nums, used);
        return ans;
    }

    private void permute0(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            permute0(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

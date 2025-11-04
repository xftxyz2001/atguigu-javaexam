import java.util.ArrayList;
import java.util.List;

public class L39 {

    List<Integer> path = new ArrayList<>();
    int sum = 0;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum0(candidates, target, 0);
        return ans;
    }

    private void combinationSum0(int[] candidates, int target, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            combinationSum0(candidates, target, i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}

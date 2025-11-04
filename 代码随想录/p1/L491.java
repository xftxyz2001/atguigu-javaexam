import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L491 {

    public static void main(String[] args) {
        System.out.println(new L491().findSubsequences(new int[] { 4, 6, 7, 7 }));
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    private void backtracking(int[] nums, int start) {
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }
        // 使用set保存本层使用过的元素，不重复使用以达到去重目的
        // https://programmercarl.com/0491.%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

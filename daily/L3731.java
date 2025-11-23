import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3731 {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        // if (nums[nums.length - 1] - nums[0] <= nums.length) {
        if (nums[nums.length - 1] - nums[0] < nums.length) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > 1) {
                for (int j = start + 1; j < nums[i]; j++) {
                    ans.add(j);
                }
            }
            start = nums[i];
        }
        return ans;
    }
}

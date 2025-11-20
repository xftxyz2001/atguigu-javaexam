import java.util.Arrays;
import java.util.HashMap;

public class Q21 {
    public int[] findErrorNums(int[] nums) {
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] != i + 1) {
        // return new int[] { nums[i], i + 1 };
        // }
        // }
        // return new int[] {};

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            int cnt = hash.getOrDefault(i, 0);
            if (cnt == 2) {
                ans[0] = i;
            } else if (cnt == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}

import java.util.Arrays;

public class L3745 {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] + nums[nums.length - 2] - nums[0];
    }
}

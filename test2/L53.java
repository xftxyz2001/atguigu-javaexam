public class L53 {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur > sum) {
                sum = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
        }
        return sum;
    }
}

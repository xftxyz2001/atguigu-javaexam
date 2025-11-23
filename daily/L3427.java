public class L3427 {
    public int subarraySum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += subarraySum(nums, i);
        }
        return sum;
    }

    private int subarraySum(int[] nums, int i) {
        int start = Math.max(0, i - nums[i]);
        int sum = 0;
        for (int j = start; j <= i; j++) {
            sum += nums[j];
        }
        return sum;
    }
}

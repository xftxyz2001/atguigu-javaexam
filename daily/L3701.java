public class L3701 {
    public int alternatingSum(int[] nums) {
        int flag = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * flag;
            flag *= -1;
        }
        return sum;
    }
}

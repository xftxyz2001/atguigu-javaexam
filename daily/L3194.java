import java.util.Arrays;

public class L3194 {
    public double minimumAverage(int[] nums) {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            int n = nums.length / 2;
            double minAvg = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) { // 操作轮数
                double avg = (nums[left] + nums[right]) / 2.0;
                minAvg = Math.min(minAvg, avg);
                left++;
                right--;
            }
            return minAvg;
    }
}

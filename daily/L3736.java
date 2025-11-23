import java.util.Arrays;

public class L3736 {
    public int minMoves(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += maxValue - nums[i];
        }
        return res;
    }
}

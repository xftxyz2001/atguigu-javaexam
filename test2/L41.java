import java.math.BigInteger;
import java.util.Arrays;

public class L41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == missMin) {
                missMin++;
            }
        }
        return missMin;
    }
}

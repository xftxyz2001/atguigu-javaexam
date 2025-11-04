import java.util.Arrays;

public class L376 {

    public static void main(String[] args) {
        new L376().wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 });
    }

    public int wiggleMaxLength(int[] nums) {
        // if (nums.length == 1) {
        // return 1;
        // }
        if (nums.length < 2) {
            return nums.length;
        }
        // int preDiff = 0;
        int preDiff = nums[1] - nums[0];
        int curDiff = 0;
        int ans = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            // if (curDiff * preDiff <= 0) {
            if (preDiff <= 0 && curDiff > 0 ||
                    preDiff >= 0 && curDiff < 0) {
                ans++;
                preDiff = curDiff;
            }
            // preDiff = curDiff;
        }
        return ans;
    }
}

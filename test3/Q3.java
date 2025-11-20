public class Q3 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (cur > ans) {
                    ans = cur;
                }
                cur = 0;
            } else {
                cur++;
            }
        }
        if (cur > ans) {
            ans = cur;
        }
        return ans;
    }
}

public class L3194_ {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i] % 3) {
                case 1:
                case 2:
                    ans++;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
public class L1437 {

    public static void main(String[] args) {
        new L1437().kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2);
    }

    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOne != Integer.MIN_VALUE && i - lastOne - 1 < k) {
                    return false;
                }
                lastOne = i;
            }
        }
        return true;
    }
}
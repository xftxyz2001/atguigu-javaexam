public class L3232 {
    public boolean canAliceWin(int[] nums) {
        int lt10 = 0;
        int ge10 = 0;
        for (int num : nums) {
            if (num < 10) {
                lt10 += num;
            } else {
                ge10 += num;
            }
        }
        return lt10 != ge10;
    }
}

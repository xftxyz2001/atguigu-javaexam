public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().subarraysDivByK(new int[] { -5 }, 5));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            for (int j = i; j < nums.length; j++) {
                s += nums[j];
                if (s % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;

    }

    // private int sum(int[] nums, int start, int end) {
    // int s = 0;
    // for (int i = start; i <= end; i++) {
    // s += nums[i];
    // }
    // return s;
    // }
}

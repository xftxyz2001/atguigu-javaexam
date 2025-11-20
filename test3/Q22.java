import java.util.LinkedList;

public class Q22 {

    // public int[] smallerNumbersThanCurrent(int[] nums) {
    // int[] ans = new int[nums.length];
    // LinkedList<Integer> stack = new LinkedList<>();
    // for (int i = 0; i < nums.length; i++) {
    // while (!stack.isEmpty() && stack.peek() >= nums[i]) {
    // stack.pop();
    // }
    // ans[i] = stack.size();
    // stack.push(nums[i]);
    // }
    // return ans;
    // }

    // public int[] smallerNumbersThanCurrent(int[] nums) {
    //     int[] ans = new int[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums.length; j++) {
    //             if (i != j && nums[j] < nums[i]) {
    //                 ans[i]++;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hash = new int[101];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]+1; j < hash.length; j++) {
                hash[j]++;
            }
        }
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = hash[nums[i]];
        }
        return ans;
    }
}

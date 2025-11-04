import java.util.Arrays;
import java.util.LinkedList;

public class L503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < res.length; i++) {
            // if (stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
            // stack.push(i);
            // } else {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
            // }
        }
        for (int i = 0; i < res.length; i++) {
            // if (stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
            // stack.push(i);
            // } else {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
            // }
        }
        return res;
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class L496 {

    public static void main(String[] args) {
        new L496().nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 });
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (stack.isEmpty() || nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    int index2 = stack.pop();
                    if (map.containsKey(nums2[index2])) {
                        int index1 = map.get(nums2[index2]);
                        // res[index1] = i;
                        res[index1] = nums2[i];
                    }
                }
                stack.push(i); // !
            }
        }

        return res;
    }
}

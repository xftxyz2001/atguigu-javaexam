import java.lang.reflect.Array;
import java.util.ArrayList;


public class L1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        ArrayList<Integer> numList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        numList.sort((o1, o2) -> Math.abs(o2) - Math.abs(o1));
        for (int i = 0; i < numList.size(); i++) {

            if (numList.get(i) < 0 && k > 0) {
                numList.set(i, -numList.get(i));
                k--;
            }
        }
        if (k % 2 == 1) {
            numList.set(numList.size() - 1, -numList.get(numList.size() - 1));
        }
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }
}

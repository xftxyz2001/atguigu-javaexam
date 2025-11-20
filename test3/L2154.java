import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class L2154 {

    // 排序+二分
    // public int findFinalValue(int[] nums, int original) {
    // Arrays.sort(nums);
    // int index = Arrays.binarySearch(nums, original);
    // while (index >= 0) {
    // // original *= 2;
    // original <<= 1;
    // index = Arrays.binarySearch(nums, index + 1, nums.length, original);
    // }
    // return original;
    // }

    // 哈希表
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }
        while (hash.contains(original)) {
            original <<= 1;
        }
        return original;

    }
}
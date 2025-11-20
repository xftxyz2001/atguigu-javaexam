public class Q2 {
    public int[] shuffle(int[] nums, int n) {
        int[] newArr = new int[nums.length];
        int k = 0;
        int i = 0, j = n;
        while (j < nums.length) {
            newArr[k++] = nums[i++];
            newArr[k++] = nums[j++];
        }
        return newArr;
    }
}

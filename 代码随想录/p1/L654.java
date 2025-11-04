public class L654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        int[] leftNums = new int[maxIndex];
        System.arraycopy(nums, 0, leftNums, 0, leftNums.length);
        treeNode.left = constructMaximumBinaryTree(leftNums);

        int[] rightNums = new int[nums.length - maxIndex - 1];
        System.arraycopy(nums, maxIndex + 1, rightNums, 0, rightNums.length);
        treeNode.right = constructMaximumBinaryTree(rightNums);
        return treeNode;
    }
}

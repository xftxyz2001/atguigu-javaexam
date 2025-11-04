public class L530 {

    Integer preVal = null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference0(root);
        return minDiff;
    }

    private void getMinimumDifference0(TreeNode root) {
        if (root == null) {
            return;
        }

        getMinimumDifference0(root.left);

        if (preVal != null) {
            int diff = root.val - preVal;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        preVal = root.val;

        getMinimumDifference0(root.right);
    }
}
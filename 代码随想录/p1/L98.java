public class L98 {
    Integer preVal = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (preVal != null && root.val <= preVal) {
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);
    }
}

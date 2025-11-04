public class L101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric0(root.left, root.right);
    }

    private boolean isSymmetric0(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric0(left.left, right.right) && isSymmetric0(left.right, right.left);
    }
}
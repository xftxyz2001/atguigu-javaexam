public class L110 {
    public boolean isBalanced(TreeNode root) {
        return balanced(root) < 0;
    }

    private int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balanced(root.left);
        if (left < 0) {
            return left;
        }
        int right = balanced(root.right);
        if (right < 0) {
            return right;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;

    }
}

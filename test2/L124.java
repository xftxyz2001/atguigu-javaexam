public class L124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum0(root);
        return ans;
    }

    public int maxPathSum0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum0(root.left);
        int right = maxPathSum0(root.right);
        int cur = Math.max(root.val, Math.max(root.val + Math.max(left, right), root.val + left + right));
        if (cur > ans) {
            ans = cur;
        }
        return cur;
    }
}

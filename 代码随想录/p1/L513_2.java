public class L513_2 {

    int maxDepth = 0;
    int result;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return result;
    }

    private void findBottomLeftValue(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }
}

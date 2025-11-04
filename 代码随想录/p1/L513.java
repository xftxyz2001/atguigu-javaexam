public class L513 {

    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1);
    }

    private Integer findBottomLeftValue(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                return root.val;
            }
            return null;
        }
        Integer resLeft = null;
        if (root.left != null) {
            resLeft = findBottomLeftValue(root.left, depth + 1);
        }
        Integer resRight = null;
        if (root.right != null) {
            resRight = findBottomLeftValue(root.right, depth + 1);
        }
        return resRight != null ? resRight : resLeft;
    }
}

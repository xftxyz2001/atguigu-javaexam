public class L450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else {
                TreeNode p = root.right;
                while (p.left != null) {
                    p = p.left;
                }
                p.left = root.left;
                return root.right;
            }
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}

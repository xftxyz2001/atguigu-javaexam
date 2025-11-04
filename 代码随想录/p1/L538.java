public class L538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        int temp = root.val;
        root.val += sum;
        sum += temp;
        convertBST(root.left);
        return root;
    }
}

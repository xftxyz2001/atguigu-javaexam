public class L106 {

    public static void main(String[] args) {
        new L106().buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) {
            return node;
        }
        int inRootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == node.val) {
                inRootIndex = i;
                break;
            }
        }
        int[] inorderLeft = new int[inRootIndex];
        System.arraycopy(inorder, 0, inorderLeft, 0, inorderLeft.length);
        int[] inorderRight = new int[inorder.length - inRootIndex - 1];
        System.arraycopy(inorder, inRootIndex + 1, inorderRight, 0, inorderRight.length);
        int[] postorderLeft = new int[inRootIndex];
        System.arraycopy(postorder, 0, postorderLeft, 0, postorderLeft.length);
        int[] postorderRight = new int[inorder.length - inRootIndex - 1];
        System.arraycopy(postorder, postorderLeft.length, postorderRight, 0, postorderRight.length);

        node.left = buildTree(inorderLeft, postorderLeft);
        node.right = buildTree(inorderRight, postorderRight);

        return node;

    }

    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    // return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
    // postorder.length - 1);
    // }

    // private TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[]
    // postorder, int postLeft, int postRight) {
    // if (postLeft > postRight) {
    // return null;
    // }
    // TreeNode node = new TreeNode(postorder[postRight]);

    // int inRootIndex = inLeft;
    // for (int i = inLeft; i <= inRight; i++) {
    // if (inorder[i] == postorder[postRight]) {
    // inRootIndex = i;
    // break;
    // }
    // }
    // node.left = buildTree(inorder, inLeft, inRootIndex - 1, postorder, postLeft,
    // postRight - (inRight - inRootIndex) - 1);
    // node.right = buildTree(inorder, inLeft, inRootIndex + 1, postorder, postLeft
    // + (inRootIndex - inLeft),
    // postRight - 1);
    // return node;
    // }

}

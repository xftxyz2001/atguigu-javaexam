import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        binaryTreePaths(root, path, result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, LinkedList<TreeNode> path, ArrayList<String> result) {
        path.add(root);
        if (root.left == null && root.right == null) {
            StringJoiner sj = new StringJoiner("->");
            for (TreeNode p : path) {
                sj.add(String.valueOf(p.val));
            }
            result.add(sj.toString());
        }
        if (root.left != null) {
            binaryTreePaths(root.left, path, result);
            path.removeLast();
        }
        if (root.right != null) {
            binaryTreePaths(root.right, path, result);
            path.removeLast();
        }
    }
}

public class L968 {
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (minCameraCover0(root) == 0) {
            ans++;
        }
        return ans;
    }

    private int minCameraCover0(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = minCameraCover0(root.left);
        int right = minCameraCover0(root.right);
        if (left == 2 && right == 2) { // 子节点被覆盖，说明本节点未被覆盖
            return 0;
        }
        if (left == 0 || right == 0) { // 存在子节点未被覆盖，需要安装摄像头
            ans++;
            return 1;
        }
        return 2;

    }
}

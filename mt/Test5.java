import java.util.ArrayList;
import java.util.Scanner;

public class Test5 {
    static int count = 0;
    static int k = 0;

    static class TreeNode {
        int val;
        ArrayList<TreeNode> childs;
        long z = 1; // 子树乘积？
        boolean flag;

        public TreeNode(int val) {
            this.val = val;
            childs = new ArrayList<>();
        }

    }

    public static void main(String[] args) {
        // System.out.println(yinzishu(8 * 9 * 21));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 节点数量
        k = sc.nextInt(); // 因子数量最小值

        // 创建节点
        // int[] nodes = new int[n + 1]; // 每个节点的值
        TreeNode[] nodes = new TreeNode[n + 1];
        for (int i = 1; i <= n; i++) {
            int ai = sc.nextInt();
            nodes[i] = new TreeNode(ai);
        }

        // 构建节点之间的联系
        // HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>(n - 1);
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // ArrayList<Integer> chlids = edges.getOrDefault(u, new ArrayList<>());
            nodes[u].childs.add(nodes[v]);
            // chlids.add(v);
            // edges.put(u, chlids);
        }
        sc.close();
        dfs(nodes[1]);
        System.out.println(count);
    }

    private static void dfs(TreeNode treeNode) {
        // // 叶子节点
        // if (treeNode.childs.size() == 0) {
        // treeNode.z = treeNode.val;
        // if (yinzishu(treeNode.z) >= k) {
        // count++;
        // }
        // return;
        // }
        // // 非叶子节点
        // // treeNode.childs.forEach(Test5::dfs);
        // for (TreeNode child : treeNode.childs) {
        // dfs(child);
        // treeNode.z *= child.z;
        // }
        boolean flag = false;
        if (treeNode.childs.size() > 0) {
            for (TreeNode child : treeNode.childs) {
                dfs(child);
                if (child.flag) {
                    flag = true;
                }
                treeNode.z *= child.z;
            }
        }
        treeNode.z *= treeNode.val;
        if (flag || yinzishu(treeNode.z) >= k) {
            treeNode.flag = true;
            count++;
        }
    }

    private static int yinzishu(long z) {
        int cnt = 0;
        // double sqrtz = Math.sqrt(z);
        // for (int i = 1; i <= sqrtz; i++) {
        // if (z % i == 0) {
        // cnt++;
        // }
        // if (i * i != z) {
        // cnt++;
        // }
        // }
        for (int i = 1; i * i <= z; i++) {
            // System.out.print(i + " ");
            if (z % i == 0) {
                // System.out.println(i);
                cnt++;
                if (i * i != z) {
                    // System.out.println(z / i);
                    cnt++;
                }
            }

        }
        return cnt;
    }

}

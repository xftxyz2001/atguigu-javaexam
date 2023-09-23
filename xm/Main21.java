import java.util.Scanner;

public class Main21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 工序的数量
        int n = Integer.parseInt(sc.nextLine());
        // 入度表
        int[] ids = new int[n];
        String nextLine = sc.nextLine();
        sc.close();

        // 标记（能否完成）
        boolean flag = true;

        if (!nextLine.isEmpty()) {
            // 前置工序列表（字符串）
            String[] split = nextLine.split(",");

            // System.out.println(split.length);
            int[][] abs = new int[split.length][2];
            // 初始化前置工序列表
            for (int i = 0; i < abs.length; i++) {
                String[] ab = split[i].split(":");
                abs[i][0] = Integer.parseInt(ab[0]);
                ids[abs[i][0]]++; // 更新入度表
                abs[i][1] = Integer.parseInt(ab[1]);
            }

            // 尚未排序的节点数量？
            int num = n;
            while (num > 0) {
                // 选择一个入度为0的点
                int index = -1;
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] <= 0) {
                        index = i;
                        break;
                    }
                }
                // 未找到入度为0的点
                if (index == -1) {
                    flag = false;
                    break;
                }
                // 将该节点指向的节点入度减少1
                for (int i = 0; i < abs.length; i++) {
                    // abs[i][0] <- abs[i][1]
                    if (abs[i][1] == index) {
                        ids[abs[i][0]]--;
                    }
                }
                num--; // 尚未排序的节点数量-1
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}

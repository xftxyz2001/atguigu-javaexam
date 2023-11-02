import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] changDiDaXiaoSplited = scanner.nextLine().split(",");
        int m = Integer.parseInt(changDiDaXiaoSplited[0]);
        int n = Integer.parseInt(changDiDaXiaoSplited[1]);

        String[] xuanShouChuShiWeiZhiSplited = scanner.nextLine().split(",");
        int x0 = Integer.parseInt(xuanShouChuShiWeiZhiSplited[0]);
        int y0 = Integer.parseInt(xuanShouChuShiWeiZhiSplited[1]);

        // String[] dianWeiGaoDuSplited = scanner.nextLine().split(",");
        // int[][] h = new int[m][n];
        // for (int i = 0; i < dianWeiGaoDuSplited.length; i++) {
        // h[i / m][i % m] = Integer.parseInt(dianWeiGaoDuSplited[i]);
        // }

        // String[] dianWeiJianSuSplited = scanner.nextLine().split(",");
        // int[][] o = new int[m][n];
        // for (int i = 0; i < dianWeiJianSuSplited.length; i++) {
        // o[i / m][i % m] = Integer.parseInt(dianWeiJianSuSplited[i]);
        // }

        String[] dianWeiGaoDuSplitedRows = scanner.nextLine().split(" ");
        int[][] h = new int[m][n];
        for (int i = 0; i < dianWeiGaoDuSplitedRows.length; i++) {
            String[] dianWeiGaoDuSplitedCol = dianWeiGaoDuSplitedRows[i].split(",");
            for (int j = 0; j < dianWeiGaoDuSplitedCol.length; j++) {
                h[i][j] = Integer.parseInt(dianWeiGaoDuSplitedCol[j]);
            }
        }

        String[] dianWeiJianSuSplitedRows = scanner.nextLine().split(" ");
        int[][] o = new int[m][n];
        for (int i = 0; i < dianWeiJianSuSplitedRows.length; i++) {
            String[] dianWeiJianSuSplitedCol = dianWeiJianSuSplitedRows[i].split(",");
            for (int j = 0; j < dianWeiJianSuSplitedCol.length; j++) {
                o[i][j] = Integer.parseInt(dianWeiJianSuSplitedCol[j]);
            }
        }

        scanner.close();

        // 初始速度为1
        // int speed0 = 1;
        // speed += h1-h2-o2;
        int[][] s = new int[m][n];
        // for (int i = 0; i < s.length; i++) {
        // for (int j = 0; j < s[i].length; j++) {
        // s[i][j] = 0;
        // }
        // }
        s[x0][y0] = 1;
        go(h, o, s, x0, y0);
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                // if (s[i][j] == 1 && i != x0 && j != y0) {
                if (s[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count - 1);
    }

    // private static void printArray(int[][] arr) {
    // for (int i = 0; i < arr.length; i++) {
    // System.out.println(Arrays.toString(arr[i]));
    // }
    // }

    /**
     * @param h  各地点高度值
     * @param o  各地点减速值
     * @param s  当前地点车速
     * @param x0 当前位置x
     * @param y0 当前位置y
     */
    private static void go(int[][] h, int[][] o, int[][] s, int x0, int y0) {
        // System.out.println("当前位置: (" + x0 + ", " + y0 + ")");
        // System.out.println("当前速度: " + s[x0][y0]);
        // printArray(h);
        // printArray(o);
        // printArray(s);
        // 没速度了
        if (s[x0][y0] <= 0) {
            return;
        }
        // 上
        if (x0 > 0 && s[x0 - 1][y0] != 1) {
            s[x0 - 1][y0] = s[x0][y0] + h[x0][y0] - h[x0 - 1][y0] - o[x0 - 1][y0];
            go(h, o, s, x0 - 1, y0);
        }

        // 左
        if (y0 > 0 && s[x0][y0 - 1] != 1) {
            s[x0][y0 - 1] = s[x0][y0] + h[x0][y0] - h[x0][y0 - 1] - o[x0][y0 - 1];
            go(h, o, s, x0, y0 - 1);
        }

        // 下
        if (x0 < s.length - 1 && s[x0 + 1][y0] != 1) {
            s[x0 + 1][y0] = s[x0][y0] + h[x0][y0] - h[x0 + 1][y0] - o[x0 + 1][y0];
            go(h, o, s, x0 + 1, y0);
        }

        // 右
        if (y0 < s[x0].length - 1 && s[x0][y0 + 1] != 1) {
            s[x0][y0 + 1] = s[x0][y0] + h[x0][y0] - h[x0][y0 + 1] - o[x0][y0 + 1];
            go(h, o, s, x0, y0 + 1);
        }

    }
}

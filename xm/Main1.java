import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int towersLength = 0; // 基站数量
        int radius = 0; // 手机能与基站通信的最远距离

        String[] split = sc.nextLine().split(",");
        towersLength = Integer.parseInt(split[0]);
        radius = Integer.parseInt(split[1]);

        // 初始化基站信息
        int[][] towers = new int[towersLength][3];
        for (int i = 0; i < towersLength; i++) {
            String[] splited = sc.nextLine().split(",");
            towers[i][0] = Integer.parseInt(splited[0]); // 基站x坐标
            towers[i][1] = Integer.parseInt(splited[1]); // 基站y坐标
            towers[i][2] = Integer.parseInt(splited[2]); // 基站覆盖范围
        }
        sc.close();

        // 找到信号最好的基站
        int bestX = -1, bestY = -1;
        double bestQ = -1;

        // 遍历手机的位置
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                // 遍历所有基站求出该位置的信号强度
                double q = 0;
                for (int i = 0; i < towers.length; i++) {
                    // 手机(x,y)覆盖基站且基站覆盖上手机
                    int minRadius = Math.min(radius, towers[i][2]); // 取两者的小值
                    // 距离
                    double d = Math.hypot(x - towers[i][0], y - towers[i][1]);
                    if (d <= minRadius) {
                        q += (int) (towers[i][2] / (1 + d)); // 向下取整
                        // q += Math.floor(towers[i][2] / (1 + d));
                    }
                }
                if (q > bestQ) {
                    bestQ = q;
                    bestX = x;
                    bestY = y;
                }
            }
        }
        System.out.println(bestX + "," + bestY);
    }
}

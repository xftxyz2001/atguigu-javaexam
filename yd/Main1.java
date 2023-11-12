import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        scanner.close();
        // 非法输入
        if (nextLine.length() < 3) {
            System.out.println(-1);
            return;
        }

        // 转数字
        String[] split = nextLine.substring(1, nextLine.length() - 1).split(",");

        // 测试
        // System.out.println(Arrays.toString(split));
        // 自动过滤了空串

        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        // 统计
        int[] cities = new int[10];
        for (int i : arr) {
            cities[i]++;
        }

        // 找到最大值
        int maxIndex = 0;
        for (int i = 1; i < cities.length; i++) {
            if (cities[i] > cities[maxIndex]) {
                maxIndex = i;
            }
        }

        // 检查是否存在多个最大值
        boolean flag = false;
        for (int i = 0; i < cities.length; i++) {
            if (i != maxIndex && cities[i] == cities[maxIndex]) {
                flag = true;
                break;
            }
        }

        // 输出
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(maxIndex + "," + cities[maxIndex]);
        }

    }
}

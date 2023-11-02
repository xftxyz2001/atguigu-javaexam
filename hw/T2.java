import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 铁路长度
        int R = scanner.nextInt(); // 基站覆盖半径
        int M = scanner.nextInt(); // 基站成本
        scanner.nextLine();

        String input = scanner.nextLine();
        scanner.close();

        String[] numsStr = input.split(" ");
        // 数目不够
        if (2 * R * numsStr.length < N) {
            System.out.println(-1);
            return;
        }

        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        // 排序
        Arrays.sort(nums);
        // 首尾覆盖不到
        if (nums[0] - R > 0 || nums[nums.length - 1] + R < N) {
            System.out.println(-1);
            return;
        }
        // 相邻基站距离大于2R
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 2 * R) {
                System.out.println(-1);
                return;
            }
        }

        // int count = 1; // 需要建设的基站数
        // int lastLength = nums[0] + R; // 当前覆盖到的位置
        // int lastLocation = nums[0]; // 覆盖到当前位置的最后一个基站位置

        ArrayList<Integer> locations = new ArrayList<>();
        locations.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            // 已达成覆盖
            if (locations.get(locations.size() - 1) + R >= N) {
                break;
            }
            if (locations.size() > 1) { // 至少有两个基站
                // 新的基站和倒数第二个基站完全覆盖倒数第一个基站
                if (locations.get(locations.size() - 2) + R >= nums[i] - R) {
                    locations.remove(locations.size() - 1);
                }
            }
            // 新建基站
            locations.add(nums[i]);
            // count++;
            // lastLength = nums[i] + R;
        }

        // System.out.println(locations.get(locations.size() - 1) + R < N ? -1 : M *
        // locations.size());

        // 未达成覆盖
        if (locations.get(locations.size() - 1) + R < N) {
            System.out.println(-1);
        } else {
            System.out.println(M * locations.size());
        }

    }
}

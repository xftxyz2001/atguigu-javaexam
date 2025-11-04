// 当前采用的是贪心策略，每次找到第一对和为素数的数字就立即配对并移除
// 这种方法不能保证得到最大匹配数，因为早期的选择可能会影响后续更优的配对
import java.util.ArrayList;
import java.util.Scanner;

public class HJ28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // int[] nums = new int[n];
        ArrayList<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            // nums[i] = in.nextInt();
            nums.add(in.nextInt());
        }
        in.close();

        int cnt = 0;
        boolean flag = false;
        do {
            flag = false;
            l: for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    if (isPrime(nums.get(i) + nums.get(j))) {
                        flag = true;
                        cnt++;
                        nums.remove(j);
                        nums.remove(i);
                        break l;
                    }
                }
            }
        } while (flag);

        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

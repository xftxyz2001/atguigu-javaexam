import java.util.Scanner;

// timeout 70
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // if (!in.hasNextInt()) {
        // in.close();
        // return;
        // }
        int t = in.nextInt();
        int[] ps = new int[t];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = in.nextInt();

            // if (in.hasNextInt()) {
            // ps[i] = in.nextInt();
            // } else {
            // in.close();
            // throw new RuntimeException("t=" + t + ", ps=" + Arrays.toString(ps)); //
            // t=10, 18 19
            // }
        }
        in.close();

        int sum = 0; // 总得分
        for (int i = 0; i < ps.length; i++) {
            sum += ps[i];
        }

        int minMVPScore = sum;
        for (int mvpCount = 2; mvpCount <= ps.length; mvpCount++) { // MVP数
            if (sum % mvpCount != 0) {
                continue;
            }
            int mvpScore = sum / mvpCount;
            boolean[] used = new boolean[ps.length];
            flag = false;
            // split(ps, used, sum, mvpCount, sum % mvpCount, 0);
            split(ps, used, sum, mvpCount, mvpScore, 0);
            if (flag) {
                // minMVPScore = Math.min(minMVPScore, sum % mvpCount);
                minMVPScore = Math.min(minMVPScore, mvpScore);
            }
        }

        System.out.println(minMVPScore);
    }

    static boolean flag = false;
    // static int deep = 0;

    private static void split(int[] ps, boolean[] used, int sum, int mvpCount, int mvpScore, int curScore) {
        // deep++;
        // for (int i = 0; i < deep; i++) {
        // System.out.print(" ");
        // }
        // System.out.println(curScore); // d
        if (mvpCount == 0) {
            flag = true;
            return;
        }
        if (sum < mvpCount * mvpScore - curScore) {
            return;
        }
        for (int i = 0; i < ps.length; i++) {
            if (!used[i]) {
                if (ps[i] + curScore > mvpScore) { // !!!
                    continue;
                }

                used[i] = true;
                if (ps[i] + curScore == mvpScore) {
                    split(ps, used, sum - ps[i], mvpCount - 1, mvpScore, 0);
                } else {
                    // split(ps, used, sum - ps[i], mvpCount, mvpScore, curScore - ps[i]);
                    split(ps, used, sum - ps[i], mvpCount, mvpScore, curScore + ps[i]);
                }
                used[i] = false;
            }
        }
        // deep--;
    }

}

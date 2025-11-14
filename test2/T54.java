import java.util.Arrays;
import java.util.Scanner;

public class T54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = in.nextInt();
        }
        in.close();

        Arrays.sort(scores);
        int cnt = 0;
        for (int i = scores.length - 1; i >= 0; i--) {
            if (scores[i] <= 0) {
                break;
            }
            if (cnt < k) {
                cnt++;
            } else {
                while (i >= 0 && scores[i] == scores[scores.length - k]) {
                    cnt++;
                    i--;
                }
                break;
            }
        }
        System.out.println(cnt);
    }
}

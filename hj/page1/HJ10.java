import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        boolean[] set = new boolean[128];
        int cnt = 0;
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!set[charArray[i]]) {
                cnt++;
            }
            set[charArray[i]] = true;
        }
        System.out.println(cnt);
    }
}

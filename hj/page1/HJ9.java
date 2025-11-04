import java.util.Scanner;

public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        in.close();

        char[] charArray = input.toCharArray();
        boolean[] set = new boolean[10];
        for (int i = charArray.length - 1; i >= 0; i--) {
            int num = charArray[i] - '0';
            if (!set[num]) {
                System.out.print(num);
            }
            set[num] = true;
        }
    }
}

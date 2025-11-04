import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int nextInt = in.nextInt();
            if (nextInt == 0) {
                break;
            }

            System.out.println(drink(nextInt));
        }
        in.close();
    }

    private static int drink(int kongPing) {
        int count = 0;
        while (kongPing >= 3) {
            int qiShui = kongPing / 3;
            count += qiShui;
            kongPing = qiShui + kongPing % 3;
        }
        if (kongPing == 2) {
            count++;
        }
        return count;
    }
}

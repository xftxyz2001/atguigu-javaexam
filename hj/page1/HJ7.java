import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        in.close();

        // System.out.println(Math.round(num));
        int ni = (int) num;
        if (num - ni >= 0.5) {
            System.out.println(ni + 1);
        } else {
            System.out.println(ni);
        }
    }
}

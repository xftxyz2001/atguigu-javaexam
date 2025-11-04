import java.util.Scanner;

public class HJ38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        in.close();

        double hd = h;
        // double s = hd;
        double s = 0;
        for (int i = 0; i < 5; i++) {
            // s += 2 * hd;
            if (i == 0) {
                s += hd;
            } else {
                s += 2 * hd;
            }
            hd /= 2;
        }
        System.out.println(s);
        System.out.println(hd);
    }
}

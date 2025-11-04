import java.util.ArrayList;
import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> link = new ArrayList<>(n);

        int h = in.nextInt();
        link.add(h);

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int bi = link.indexOf(b);
            link.add(bi + 1, a);
        }

        int k = in.nextInt();
        in.close();

        link.remove(Integer.valueOf(k));
        for (int i = 0; i < link.size(); i++) {
            System.out.print(link.get(i));
            if (i != link.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}

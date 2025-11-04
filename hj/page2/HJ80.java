import java.util.Scanner;
import java.util.TreeSet;

public class HJ80 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            set.add(in.nextInt());
        }
        in.close();

        for (Integer i : set) {
            System.out.print(i);
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class HJ58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        in.close();

        list.sort(Integer::compareTo);
        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i));
            if (i != k - 1) {
                System.out.print(" ");
            }
        }
    }
}

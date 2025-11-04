
import java.util.Scanner;

public class HJ41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ms = new int[n];
        int[] xs = new int[n];
        for (int i = 0; i < n; i++) {
            ms[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            xs[i] = in.nextInt();
        }
        in.close();

        
    }
}

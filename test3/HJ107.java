import java.util.Scanner;

public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(k < n ? "YES" : "NO");
    }
}

import java.util.Scanner;

public class HJ46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        int k = in.nextInt();
        in.close();
        System.out.println(line.substring(0, k));
    }
}

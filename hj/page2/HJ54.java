import java.util.Scanner;

public class HJ54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        String[] split = line.split(",");
        long b = Long.parseLong(split[1]);
        long c = Long.parseLong(split[split.length - 1]);
        System.out.println(c - b - 1);
    }
}

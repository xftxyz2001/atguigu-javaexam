import java.util.Scanner;

public class HJ5_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        in.close();

        int num = Integer.parseInt(inputStr.substring(2), 16);
        System.out.println(num);

    }
}

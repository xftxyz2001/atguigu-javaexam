import java.util.Arrays;
import java.util.Scanner;

public class HJ34 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        char[] charArray = line.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);
    }
}
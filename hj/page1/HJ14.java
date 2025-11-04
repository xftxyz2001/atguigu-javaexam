import java.util.Arrays;
import java.util.Scanner;

public class HJ14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        String[] strings = new String[cnt];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = in.next();
        }
        in.close();

        Arrays.sort(strings, String::compareTo);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

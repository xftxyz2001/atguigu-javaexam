// !!!超时!!!
import java.util.Scanner;

public class HJ32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        in.close();

        System.out.println(decode(str).length());
    }

    private static String decode(String str) {
        char[] charArray = str.toCharArray();
        boolean flag = true;
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return str;
        }

        String s0 = decode(new String(charArray, 1, charArray.length - 1));
        String s1 = decode(new String(charArray, 0, charArray.length - 1));
        if (s0.length() > s1.length()) {
            return s0;
        } else {
            return s1;
        }
    }
}

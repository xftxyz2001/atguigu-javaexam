import java.util.Scanner;

public class HJ65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        in.close();

        if (str2.length() < str1.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        String maxLenSameSubString = str1;
        l: for (int len = str1.length(); len >= 0; len--) {
            for (int i = 0; i + len <= str1.length(); i++) {
                String substring = str1.substring(i, i + len);
                if (str2.indexOf(substring) != -1) {
                    // if (substring.length() < minLenSameSubString.length()) {
                    // minLenSameSubString = substring;
                    // }
                    maxLenSameSubString = substring;
                    break l;
                }
            }
        }
        System.out.println(maxLenSameSubString);

    }
}

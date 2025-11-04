import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String l1 = in.nextLine();
        String l2 = in.nextLine();
        in.close();

        System.out.println(encode(l1));
        System.out.println(decode(l2));
    }

    private static String decode(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isAlphabetic(charArray[i])) {
                if (Character.isUpperCase(charArray[i])) {
                    charArray[i] = (char) ((charArray[i] - 'A' + 26 - 1) % 26 + 'a');
                } else {
                    charArray[i] = (char) ((charArray[i] - 'a' + 26 - 1) % 26 + 'A');
                }
            } else if (Character.isDigit(charArray[i])) {
                charArray[i] = (char) ((charArray[i] - '0' + 10 - 1) % 10 + '0');
            }
        }
        return new String(charArray);
    }

    private static String encode(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isAlphabetic(charArray[i])) {
                if (Character.isUpperCase(charArray[i])) {
                    charArray[i] = (char) ((charArray[i] - 'A' + 1) % 26 + 'a');
                } else {
                    charArray[i] = (char) ((charArray[i] - 'a' + 1) % 26 + 'A');
                }
            } else if (Character.isDigit(charArray[i])) {
                charArray[i] = (char) ((charArray[i] - '0' + 1) % 10 + '0');
            }
        }
        return new String(charArray);
    }
}

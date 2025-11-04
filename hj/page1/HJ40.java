import java.util.Scanner;

public class HJ40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        char[] charArray = line.toCharArray();

        int alpha = 0;
        int space = 0;
        int digit = 0;
        int other = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isAlphabetic(charArray[i])) {
                alpha++;
            } else if (charArray[i] == ' ') {
                space++;
            } else if (Character.isDigit(0)) {
                digit++;
            } else {
                other++;
            }
        }

        System.out.println(alpha);
        System.out.println(space);
        System.out.println(digit);
        System.out.println(other);
    }
}

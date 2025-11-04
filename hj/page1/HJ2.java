import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.next();
        char ch = in.next().charAt(0);
        in.close();

        int cnt = 0;
        if (Character.isAlphabetic(ch)) {
            char upperCase = Character.toUpperCase(ch);
            char lowerCase = Character.toLowerCase(ch);
            for (char c : line.toCharArray()) {
                if (c == upperCase || c == lowerCase) {
                    cnt++;
                }
            }
        } else if (Character.isDigit(ch)) {
            for (char c : line.toCharArray()) {
                if (c == ch) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

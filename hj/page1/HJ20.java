import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (check(line)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }

        }
        in.close();
    }

    private static boolean check(String line) {
        if (line.length() < 8) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean other = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCase = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCase = true;
            } else if (Character.isDigit(ch)) {
                digit = true;
            } else {
                other = true;
            }
        }
        int cnt = 0;
        if (upperCase) {
            cnt++;
        }
        if (lowerCase) {
            cnt++;
        }
        if (digit) {
            cnt++;
        }
        if (other) {
            cnt++;
        }
        if (cnt < 3) {
            return false;
        }

        for (int subStrLen = 3; subStrLen < line.length() / 2; subStrLen++) {
            for (int startIndex = 0; startIndex + 2 * subStrLen <= line.length(); startIndex++) {
                String substring = line.substring(startIndex, startIndex + subStrLen);
                int lastIndexOf = line.lastIndexOf(substring);
                if (lastIndexOf != startIndex) {
                    return false;
                }
            }
        }
        return true;
    }
}

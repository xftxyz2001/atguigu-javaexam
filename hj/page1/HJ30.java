import java.util.Scanner;

public class HJ30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        in.close();

        String u = s + t;
        char[] charArray = u.toCharArray();
        for (int i = 0; i < charArray.length; i += 2) {
            int minIndex = i;
            for (int j = i + 2; j < charArray.length; j += 2) {
                if (charArray[j] < charArray[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                char temp = charArray[i];
                charArray[i] = charArray[minIndex];
                charArray[minIndex] = temp;
            }
        }
        for (int i = 1; i < charArray.length; i += 2) {
            int minIndex = i;
            for (int j = i + 2; j < charArray.length; j += 2) {
                if (charArray[j] < charArray[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                char temp = charArray[i];
                charArray[i] = charArray[minIndex];
                charArray[minIndex] = temp;
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (isHex(charArray[i])) {
                charArray[i] = doChar(charArray[i]);
            }
        }

        System.out.println(charArray);
    }

    private static char doChar(char c) {
        int d = 0;
        if (c >= '0' && c <= '9') {
            d = c - '0';
        } else if (c >= 'A' && c <= 'F') {
            d = c - 'A' + 10;
        } else if (c >= 'a' && c <= 'f') {
            d = c - 'a' + 10;
        }
        String bs = Integer.toBinaryString(d);
        StringBuilder sb = new StringBuilder(bs);
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        sb.reverse();
        // int i1 = Integer.parseInt(sb.toString(), 2);
        // String hs = Integer.toHexString(i1);
        // System.out.println(hs);
        char res = '0';
        switch (sb.toString()) {
            case "0000":
                res = '0';
                break;
            case "0001":
                res = '1';
                break;
            case "0010":
                res = '2';
                break;
            case "0011":
                res = '3';
                break;
            case "0100":
                res = '4';
                break;
            case "0101":
                res = '5';
                break;
            case "0110":
                res = '6';
                break;
            case "0111":
                res = '7';
                break;
            case "1000":
                res = '8';
                break;
            case "1001":
                res = '9';
                break;
            case "1010":
                res = 'A';
                break;
            case "1011":
                res = 'B';
                break;
            case "1100":
                res = 'C';
                break;
            case "1101":
                res = 'D';
                break;
            case "1110":
                res = 'E';
                break;
            case "1111":
                res = 'F';
                break;

            default:
                break;
        }
        return res;
    }

    private static boolean isHex(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }
}

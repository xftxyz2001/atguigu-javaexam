import java.util.ArrayList;
import java.util.Scanner;

public class HJ92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        ArrayList<String> list = new ArrayList<>();
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                // if (sb.length() > len) {
                // len = sb.length();
                // list.clear();

                // list.add(sb.toString());
                // sb.setLength(0);
                // } else if (sb.length() == len && len != 0) {
                // list.add(sb.toString());
                // sb.setLength(0);
                // }
                if (sb.length() > len) {
                    len = sb.length();
                    list.clear();

                    list.add(sb.toString());
                } else if (sb.length() != 0 && sb.length() == len) {
                    list.add(sb.toString());
                }
                sb.setLength(0);
            }
        }
        if (sb.length() > len) {
            list.clear();
            list.add(sb.toString());
            len = sb.length();
        } else if (sb.length() == len) {
            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println("," + len);
    }
}

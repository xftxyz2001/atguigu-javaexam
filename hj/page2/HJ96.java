import java.util.Scanner;

public class HJ96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                if (!flag) {
                    sb.append('*');
                }
                flag = true;
            } else {
                if (flag) {
                    sb.append('*');
                }
                flag = false;
            }
            sb.append(line.charAt(i));
        }
        if (flag) {
            sb.append('*');
        }
        System.out.println(sb);
    }
}

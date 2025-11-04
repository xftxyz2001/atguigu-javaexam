import java.util.Scanner;

public class HJ84 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        char[] charArray = line.toCharArray();
        int cnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

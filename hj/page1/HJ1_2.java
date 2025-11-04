import java.util.Scanner;

public class HJ1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        in.close();

        char[] charArray = inputStr.toCharArray();
        int cnt = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}

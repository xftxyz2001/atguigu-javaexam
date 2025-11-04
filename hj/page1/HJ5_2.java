import java.util.Scanner;

public class HJ5_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.next();
        in.close();

        char[] charArray = inputStr.toCharArray();
        int result = 0;
        f: for (int i = 2; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    result = result * 16 + (charArray[i] - '0');
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    result = result * 16 + (charArray[i] - 'A' + 10);
                    break;
                case 'x':
                    break f;
            }
        }

        System.out.println(result);

    }
}

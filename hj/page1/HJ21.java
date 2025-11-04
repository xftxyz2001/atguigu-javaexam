import java.util.Scanner;

public class HJ21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {

                charArray[i] = (char) ((Character.toLowerCase(charArray[i]) - 'a' + 1) % 26 + 'a');
            } else if (Character.isLowerCase(charArray[i])) {

                switch (charArray[i]) {
                    case 'a':
                    case 'b':
                    case 'c':
                        charArray[i] = '2';
                        break;
                    case 'd':
                    case 'e':
                    case 'f':
                        charArray[i] = '3';
                        break;
                    case 'g':
                    case 'h':
                    case 'i':
                        charArray[i] = '4';
                        break;
                    case 'j':
                    case 'k':
                    case 'l':
                        charArray[i] = '5';
                        break;
                    case 'm':
                    case 'n':
                    case 'o':
                        charArray[i] = '6';
                        break;
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                        charArray[i] = '7';
                        break;
                    case 't':
                    case 'u':
                    case 'v':
                        charArray[i] = '8';
                        break;
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        charArray[i] = '9';
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(charArray);
    }
}

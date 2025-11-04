import java.util.Scanner;

public class HJ11_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        // char[] charArray = line.toCharArray();
        // for (int i = 0; i < charArray.length / 2; i++) {
        //     char temp = charArray[i];
        //     charArray[i] = charArray[charArray.length - i - 1];
        //     charArray[charArray.length - i - 1] = temp;
        // }
        // System.out.println(charArray);
        StringBuilder sb = new StringBuilder(line);
        System.out.println(sb.reverse());
    }
}

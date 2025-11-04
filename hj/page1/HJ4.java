import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        in.close();

        int zeroCnt = 8 - inputStr.length() % 8;
        for (int i = 0; i < inputStr.length(); i += 8) {
            if (i + 8 > inputStr.length()) {
                String substring = inputStr.substring(i, inputStr.length()); // IndexOutOfBoundsException - if the
                                                                             // beginIndex is negative, or endIndex is
                                                                             // larger than the length of this String
                                                                             // object, or beginIndex is larger than
                                                                             // endIndex.
                System.out.print(substring);
                for (int j = 0; j < zeroCnt; j++) {
                    System.out.print("0");
                }
                System.out.println();
            } else {
                String substring = inputStr.substring(i, i + 8);
                System.out.println(substring);
            }
        }
    }
}

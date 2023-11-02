import java.util.Scanner;

/**
 * Words
 */
public class Words {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String words[] = input.split(" ");
        int length = 0;
        for (String string : words) {
            length += string.length();
        }
        System.out.printf("%.2f", (double) length / words.length);
    }
}
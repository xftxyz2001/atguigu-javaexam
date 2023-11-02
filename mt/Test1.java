import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        int a = 0;
        char[] charArray = line.toCharArray();
        for (char c : charArray) {
            int num = c - '0';
            if (num > a) {
                a = num;
            }
        }
        System.out.println(a);
    }
}

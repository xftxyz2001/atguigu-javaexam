import java.util.Scanner;

public class HJ13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] splited = line.split(" ");
        for (int i = splited.length - 1; i > 0; i--) {
            System.out.print(splited[i] + " ");
        }
        System.out.println(splited[0]);
    }
}

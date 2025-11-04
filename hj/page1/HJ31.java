import java.util.Scanner;
import java.util.StringJoiner;

public class HJ31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] splited = line.split("[^A-Za-z]");
        for (int i = 0; i < splited.length / 2; i++) {
            String temp = splited[i];
            splited[i] = splited[splited.length - 1 - i];
            splited[splited.length - 1 - i] = temp;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (String string : splited) {
            sj.add(string);
        }
        System.out.println(sj);
    }
}

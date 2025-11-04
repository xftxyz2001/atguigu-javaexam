import java.math.BigInteger;
import java.util.Scanner;

public class HJ57_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger i1 = new BigInteger(in.nextLine());
        BigInteger i2 = new BigInteger(in.nextLine());
        in.close();
        System.out.println(i1.add(i2));
    }
}

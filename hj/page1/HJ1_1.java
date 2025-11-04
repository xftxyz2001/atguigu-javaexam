
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        in.close();
        String[] split = inputStr.split(" ");
        if (split.length > 0) {
            System.out.println(split[split.length - 1].length());
        } else {
            System.out.println(0);
        }
    }
}
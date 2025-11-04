import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HJ70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mtrs = new int[n][2];
        for (int i = 0; i < mtrs.length; i++) {
            mtrs[i][0] = in.nextInt();
            mtrs[i][1] = in.nextInt();
        }
        String ops = in.next();
        in.close();

        int cnt = 0;
        LinkedList<Character> opStack = new LinkedList<>();
        for (int i = 0; i < ops.length(); i++) {
            char ch = ops.charAt(i);
            if (ch == '(') {
                opStack.push('(');
            } else if (ch == ')') {
                
            } else {
            }
        }
        System.out.println(cnt);
    }
}

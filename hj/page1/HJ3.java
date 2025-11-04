import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCnt = in.nextInt();
        boolean[] numArr = new boolean[501];
        for (int i = 0; i < numCnt; i++) {
            numArr[in.nextInt()] = true;
        }
        in.close();

        for (int i = 1; i < numArr.length; i++) {
            if (numArr[i]) {
                System.out.println(i);
            }
        }

    }
}

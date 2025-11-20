import java.util.Scanner;

public class HJ104 {

    static int score;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        char[][] mx = new char[n][m]; // *o
        for (int i = 0; i < mx.length; i++) {
            String line = in.next();
            for (int j = 0; j < mx[i].length; j++) {
                mx[i][j] = line.charAt(j);
            }
        }
        in.close();

        doMx(mx, k);
    }

    private static void doMx(char[][] mx, int k) {
        if (k == 0) {
            score = Math.max(getScore(mx), score);
        }
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                if (mx[i][j] == 'o') {
                    mx[i][j] = 'r';
                    doMx(mx, k - 1);
                    mx[i][j] = 'o';
                }
            }
        }
    }

    private static int getScore(char[][] mx) {
        int sc = 0;
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                if (mx[i][j] == 'r') {
                    if (i < mx.length - 1 && mx[i + 1][j] == 'r') {
                        sc++;
                    }
                }
            }
        }
        return sc;
    }
}

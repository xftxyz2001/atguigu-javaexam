import java.util.Scanner;

public class HJ69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        int[][] m1 = new int[x][y];
        int[][] m2 = new int[y][z];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] = in.nextInt();
            }
        }
        in.close();

        int[][] m3 = new int[x][z];
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {

                for (int ii = 0; ii < y; ii++) {
                    m3[i][j] += m1[i][ii] * m2[ii][j];
                }

            }
        }

        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {
                System.out.print(m3[i][j]);
                if (j != m3[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}

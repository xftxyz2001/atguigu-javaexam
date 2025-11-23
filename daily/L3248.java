import java.util.List;

public class L3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] arr = new int[n][n];
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = num++;
            }
        }

        int row = 0, col = 0;
        for (String cmd : commands) {
            switch (cmd) {
                case "UP":
                    row--;
                    break;
                case "RIGHT":
                    col++;
                    break;
                case "DOWN":
                    row++;
                    break;
                case "LEFT":
                    col--;
                    break;

                default:
                    break;
            }
        }
        return arr[row][col];
    }
}

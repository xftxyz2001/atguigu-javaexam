import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L51 {

    // public static void main(String[] args) {
    // System.out.println(new L51().solveNQueens(4));
    // }

    Set<Integer> columns = new HashSet<Integer>();
    Set<Integer> diagonals1 = new HashSet<Integer>();
    Set<Integer> diagonals2 = new HashSet<Integer>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];

        solveNQueens(chessboard, n, 0);
        return ans;
    }

    private void solveNQueens(char[][] chessboard, int n, int row) {
        if (row == n) {
            ans.add(toStringList(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            chessboard[row][i] = 'Q';
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            solveNQueens(chessboard, n, row + 1);
            chessboard[row][i] = '.';
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    private List<String> toStringList(char[][] chessboard) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chessboard.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'Q') {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

}

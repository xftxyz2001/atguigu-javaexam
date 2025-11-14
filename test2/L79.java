// Error
public class L79 {

    public static void main(String[] args) {
        new L79().exist(new char[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } }, "ABCB");
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (exist0(board, i, j, 0, word.substring(1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist0(char[][] board, int i, int j, int dir, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (dir != 3 && i > 0 && board[i - 1][j] == word.charAt(0)) { // 1
            if (exist0(board, i - 1, j, 1, word.substring(1))) {
                return true;
            }
        }
        if (dir != 4 && j > 0 && board[i][j - 1] == word.charAt(0)) { // 2
            if (exist0(board, i, j - 1, 2, word.substring(1))) {
                return true;
            }
        }
        if (dir != 1 && i < board.length - 1 && board[i + 1][j] == word.charAt(0)) { // 3
            if (exist0(board, i + 1, j, 3, word.substring(1))) {
                return true;
            }
        }
        if (dir != 2 && j < board[i].length - 1 && board[i][j + 1] == word.charAt(0)) { // 4
            if (exist0(board, i, j + 1, 4, word.substring(1))) {
                return true;
            }
        }
        return false;
    }
}
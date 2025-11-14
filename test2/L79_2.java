// Error
public class L79_2 {

    public static void main(String[] args) {
        new L79_2().exist(new char[][] {
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
                char temp = board[i][j];
                board[i][j] = '\0';
                if (exist0(board, i, j, word.substring(1))) {
                    return true;
                }
                board[i][j] = temp;
            }
        }
        return false;
    }

    private boolean exist0(char[][] board, int i, int j, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (i > 0 && board[i - 1][j] == word.charAt(0)) { // 1
            char temp = board[i - 1][j];
            board[i - 1][j] = '\0';
            if (exist0(board, i - 1, j, word.substring(1))) {
                return true;
            }
            board[i - 1][j] = temp;
        }
        if (j > 0 && board[i][j - 1] == word.charAt(0)) { // 2
            char temp = board[i][j - 1];
            board[i][j - 1] = '\0';
            if (exist0(board, i, j - 1, word.substring(1))) {
                return true;
            }
            board[i][j - 1] = temp;
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(0)) { // 3
            char temp = board[i + 1][j];
            board[i + 1][j] = '\0';
            if (exist0(board, i + 1, j, word.substring(1))) {
                return true;
            }
            board[i + 1][j] = temp;
        }
        if (j < board[i].length - 1 && board[i][j + 1] == word.charAt(0)) { // 4
            char temp = board[i][j + 1];
            board[i][j + 1] = '\0';
            if (exist0(board, i, j + 1, word.substring(1))) {
                return true;
            }
            board[i][j + 1] = temp;
        }
        return false;
    }
}
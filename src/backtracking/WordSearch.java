package backtracking;

/**
 * Created by rajat on 6/15/16.
 */
public class WordSearch {

    public static final int[] NEIGHBOUR = {-1, 1};

    public boolean exist(char[][] board, String word) {
        boolean result = false;
        if (word == null || word.length() == 0) return result;
        if (board == null) return result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (formWord(board, word, 0, i, j)) {
                    result = true;
                    break;
                }
            }
            if (result) break;
        }
        return result;
    }

    public boolean formWord(char[][] board, String word, int len, int x, int y) {
        if (len == word.length()) {
            return true;
        } else if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#') {
            return false;
        } else {
            boolean b = false;
            if (word.charAt(len) == board[x][y]) {
                char c = board[x][y];
                board[x][y] = '#';
                for (int i : NEIGHBOUR) {
                    if (formWord(board, word, len + 1, x + i, y)
                            || formWord(board, word, len + 1, x, y + i)) {
                        b = true;
                        break;
                    }
                }
                board[x][y] = c;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(ws.exist(board, "ABCESEEEFS"));
    }
}

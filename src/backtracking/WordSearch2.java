package backtracking;

import java.util.*;

/**
 * Created by rajat on 6/15/16.
 */
public class WordSearch2 {

    private static final int[] NEIGHBOURS = {-1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return new ArrayList<>(result);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                char[] partial = new char[maxLength(words)];
                findWordUtil(board, dict, partial, 0, i, j, result);
            }
        }
        return new ArrayList<>(result);
    }

    private int maxLength(String[] words) {
        int max = -1;
        for (String word : words) {
            if (word.length() > max) max = word.length();
        }
        return max;
    }

    private void findWordUtil(char[][] board, Set<String> words, char[] partial, int pos, int x, int y, Set<String> result) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#' || pos == partial.length)
            return;
        char c = board[x][y];
        partial[pos] = c;
        String value = String.copyValueOf(partial, 0, pos + 1);
        if (words.contains(value)) result.add(value);
        board[x][y] = '#';
        for (int i : NEIGHBOURS) {
            findWordUtil(board, words, partial, pos + 1, x + i, y, result);
            findWordUtil(board, words, partial, pos + 1, x, y + i, result);
        }
        board[x][y] = c;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearch2().findWords(board, words));
    }
}

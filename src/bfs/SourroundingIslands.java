package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by rajat on 6/20/16.
 */
public class SourroundingIslands {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') solveUtil(board, i, 0, m, n);
            if (board[i][n - 1] == 'O') solveUtil(board, i, n - 1, m, n);
        }

        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') solveUtil(board, 0, j, m, n);
            if (board[m - 1][j] == 'O') solveUtil(board, m - 1, j, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    private void solveUtil(char[][] board, int x, int y, int m, int n) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(x, y));
        board[x][y] = '#';
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.x - 1 >= 0 && board[p.x - 1][p.y] == 'O') {
                queue.offer(new Pair(p.x - 1, p.y));
                board[p.x - 1][p.y] = '#';
            }
            if (p.x + 1 < m && board[p.x + 1][p.y] == 'O') {
                queue.offer(new Pair(p.x + 1, p.y));
                board[p.x + 1][p.y] = '#';
            }
            if (p.y - 1 >= 0 && board[p.x][p.y - 1] == 'O') {
                queue.offer(new Pair(p.x, p.y - 1));
                board[p.x][p.y - 1] = '#';
            }
            if (p.y + 1 < n && board[p.x][p.y + 1] == 'O') {
                queue.offer(new Pair(p.x, p.y + 1));
                board[p.x][p.y + 1] = '#';
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] input = {{'O'}};
        new SourroundingIslands().solve(input);
        System.out.println(Arrays.toString(input));
    }
}

package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by rajat on 6/21/16.
 */
public class WallsAndNut {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<Pair> queue = new ArrayDeque<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) queue.offer(new Pair(i, j));
            }
        }

        Pair[] neighbours = {new Pair(-1, 0), new Pair(1, 0),
                new Pair(0, 1), new Pair(0, -1)};
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (Pair neighbor : neighbours) {
                int i = p.x + neighbor.x;
                int j = p.y + neighbor.y;
                if (i >= 0 && i < m && j >= 0 && j < n && rooms[i][j] > rooms[p.x][p.y]) {
                    rooms[i][j] = rooms[p.x][p.y] + 1;
                    queue.offer(new Pair(i, j));
                }
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

}

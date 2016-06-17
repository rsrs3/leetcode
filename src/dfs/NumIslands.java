package dfs;

/**
 * Created by rajat on 6/16/16.
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && grid[i][j] != '#') {
                    numIslandsUtil(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void numIslandsUtil(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0' || grid[x][y] == '#') return;
        grid[x][y] = '#';
        numIslandsUtil(grid, x - 1, y);
        numIslandsUtil(grid, x, y - 1);
        numIslandsUtil(grid, x + 1, y);
        numIslandsUtil(grid, x, y + 1);
    }
}

package DynamicProgramming;

/**
 * Created by rajat on 6/17/16.
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; ++i) sum[i][0] = sum[i - 1][0] + grid[i][0];
        for (int j = 1; j < grid[0].length; ++j) sum[0][j] = sum[0][j - 1] + grid[0][j];
        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[0].length; ++j) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 2},
                {1, 1}
        };
        System.out.println(new MinPathSum().minPathSum(input));
    }
}

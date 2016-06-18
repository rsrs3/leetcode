package DynamicProgramming;

/**
 * Created by rajat on 6/18/16.
 */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < obstacleGrid.length; ++i) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] != 0)
                dp[i][0] = 1;
        }
        for (int j = 1; j < obstacleGrid[0].length; ++j) {
            if (obstacleGrid[0][j] == 0 && dp[0][j - 1] != 0)
                dp[0][j] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; ++i) {
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

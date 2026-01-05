package suixianglu.dp;

public class L63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0 && obstacleGrid[0][0] == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (i == 0) {
                    if (obstacleGrid[i][j] == 0)
                        dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = 0;
                    continue;
                }

                if (j == 0) {
                    if (obstacleGrid[i][j] == 0)
                        dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = 0;
                    continue;
                }

                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

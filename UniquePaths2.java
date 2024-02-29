package org.dp;

import java.util.Arrays;

public class UniquePaths2 {

 static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] dp1 : dp) Arrays.fill(dp1, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }

    static int uniquePaths1D(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] += dp[j - 1];
        return dp[n - 1];
    }

    //  dp[i][j]: the number of unique paths to reach the cell at position (i, j) in the grid without any obstacle.
    public int uniquePaths2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        // or dp[1][0] = 1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    //    dp[j]: the number of unique paths to reach the cell at column j in the current row without any obstacle.
    public int uniquePaths21D(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }


}

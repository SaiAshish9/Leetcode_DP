package org.dp;

import java.util.Arrays;

public class MinPathSum {
   //  dp[i][j] represents the minimum path sum to reach the cell at row i and column j in a 2D grid
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][0] += dp[i - 1][0];
                } else if (j > 0) {
                    dp[0][j] += dp[0][j - 1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[m - 1][n - 1];
    }
}

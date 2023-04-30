package com.sai;

public class UniquePaths2 {

    static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        // or dp[1][0] = 1
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (obstacleGrid[i - 1][j - 1] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m][n];
    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles1(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        })); // 2
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        })); // 2
    }
}

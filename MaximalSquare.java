package org.dp;

import java.util.Arrays;

public class MaximalSquare {

    // dp[i][j]: Represents the side length of the largest square ending at the cell (i, j).
    public static int maximalSquare(char[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        System.out.println(Arrays.deepToString(dp).replaceAll("],", "],\n"));
        return maxLength * maxLength;
    }

  public static void main(String[] args) {
    System.out.println(maximalSquare(
    new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }));
  }

}

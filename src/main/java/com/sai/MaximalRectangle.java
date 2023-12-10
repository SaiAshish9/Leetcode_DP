package com.sai;

import static com.sai.WildCartMatching.print;

public class MaximalRectangle {

class Solution {
    // dp[i][j]: Represents the side length of the largest square ending at the cell (i, j).
  public int maximalSquare(char[][] matrix) {
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

    return maxLength * maxLength;
  }
}


// dp[i][j] represents the height of consecutive '1's ending at the cell (i, j) in the binary matrix
    static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0)
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[i][j] = matrix[i][j] == '1' ? (dp[i - 1][j] + 1) : 0;
                int min = dp[i][j];
                for (int k = j; k >= 0; k--) {
                    if (min == 0) break;
                    if (dp[i][k] < min) min = dp[i][k];
                    maxArea = Math.max(maxArea, min * (j - k + 1));
                }
            }
        }
        print(dp, n - 1, m-1);
        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }
        )); // 6
    }

}




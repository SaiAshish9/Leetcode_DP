package com.sai;

import java.util.Arrays;

public class MaximalSquare {

    static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int maxLength = 0;
        int prev = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int cache = dp[j];
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                    dp[j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                maxLength = Math.max(maxLength, dp[j]);
                prev = cache;
            }
        System.out.println(Arrays.toString(dp));
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        })); // 4
    }

}



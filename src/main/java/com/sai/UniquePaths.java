package com.sai;

import java.util.Arrays;

import static com.sai.WildCartMatching.print;

public class UniquePaths {

    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] dp1 : dp) Arrays.fill(dp1, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        print(dp, m - 1, n - 1);
        return dp[m - 1][n - 1];
    }

    static int uniquePaths1D(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] += dp[j - 1];
        System.out.println();
        System.out.println();
        System.out.println(Arrays.toString(dp));
        System.out.println();
        System.out.println();
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths1D(3, 2)); // 3
    }

}

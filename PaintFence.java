package com.sai;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PaintFence {

    public static int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        // `dp[i][0]` same color
        // `dp[i][1]` different color
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = k;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1]; // or else 3-posts the same color
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return dp[n - 1][0] + dp[n - 1][1];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3, 2)); // 16
    }

}






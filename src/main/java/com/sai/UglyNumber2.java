package com.sai;

import java.util.Arrays;

public class UglyNumber2 {

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            p2 = (dp[i] == dp[p2] * 2) ? p2 + 1 : p2;
            p3 = (dp[i] == dp[p3] * 3) ? p3 + 1 : p3;
            p5 = (dp[i] == dp[p5] * 5) ? p5 + 1 : p5;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10)); // 12
    }

}



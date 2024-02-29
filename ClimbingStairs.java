package org.dp;

import java.util.Arrays;

public class ClimbingStairs {

    //  dp[i] represents the number of distinct ways to climb a staircase with i steps
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

}

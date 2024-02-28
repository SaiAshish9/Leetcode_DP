package com.sai;

import java.util.Arrays;

public class MaximumSubArray {
    public static int maxSubArray(int[] a) {
        int n = a.length;
        int dp[] = new int[n];
        dp[0] = a[0];
        int big = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
            if (dp[i] > big) big = dp[i];
        }
        System.out.println();
        System.out.println();
        System.out.println(Arrays.toString(dp));
        System.out.println();
        System.out.println();
        return big;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
    }
}




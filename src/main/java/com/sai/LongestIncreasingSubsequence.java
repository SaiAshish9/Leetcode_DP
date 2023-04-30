package com.sai;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(nums));
        System.out.println();
        System.out.println(Arrays.toString(dp));
        System.out.println();
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 3
    }

}




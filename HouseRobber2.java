package com.sai;

import java.util.Arrays;

public class HouseRobber2 {


    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;

        // case-1: Rob the first house, not the last one.
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        dp[n] = dp[n - 1]; // not robbing last one

        // case-2: Not rob the first, might or may not rob  the last one
        int[] dp2 = new int[n + 1];
        dp2[0] = 0;
        dp2[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));
        return Math.max(dp[n], dp2[n]);
    }


    static int robH(int[] nums, int l, int r) {
        int prev1 = 0; // dp[i - 1]
        int prev2 = 0; // dp[i - 2]
        for (int i = l; i <= r; ++i) {
            int dp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }

    static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        return Math.max(robH(nums, 0, nums.length - 2), robH(nums, 1, nums.length - 1));
    }

    public static void main(String[] args) {
        System.out.println(rob1(new int[]{1, 2, 1})); // 2
    }

}

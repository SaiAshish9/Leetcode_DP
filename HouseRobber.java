package com.sai;

import java.util.Arrays;

public class HouseRobber {

    static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }

    static int robSpaceOptimized(int[] nums) {
        int a = 0, b = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
    }




}

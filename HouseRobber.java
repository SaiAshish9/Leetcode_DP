package com.sai;

import java.util.Arrays;

public class HouseRobber {

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
//  the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and 
// it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// dp[i] represents the maximum amount of money that can be robbed from the first i houses.
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
        // Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
    }




}

package org.dp;

import java.util.Arrays;

public class MaximumSubarrayOf0s {

    // dp[i] represents the maximum subarray sum ending at index i in the modified array
    private static int maxZeroSubarray(int[] nums) {
        int n = nums.length;

        // Convert 0s to -1s
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (nums[i] == 0) ? -1 : 1;
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }

        int maxSum = Arrays.stream(dp).max().getAsInt();
        System.out.println(Arrays.toString(dp));

        return (maxSum > 0) ? maxSum : 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1};
        int result = maxZeroSubarray(nums);
        System.out.println("Maximum subarray of 0s length: " + result);
    }

}

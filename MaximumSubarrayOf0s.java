package org.dp;

import java.util.Arrays;

public class MaximumSubarrayOf0s {

    // dp[i] represents the maximum subarray sum ending at index i in the modified array
    private static int maxZeroSubarray(int[] nums) {
        int n = nums.length;

        // Convert 0s to -1s
        int[] modifiedArray = new int[n];
        for (int i = 0; i < n; i++) {
            modifiedArray[i] = (nums[i] == 0) ? -1 : 1;
        }

        // Dynamic programming to find maximum subarray sum
        int[] dp = new int[n];
        dp[0] = modifiedArray[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + modifiedArray[i], modifiedArray[i]);
        }

        // Find the maximum subarray sum
        int maxSum = Arrays.stream(dp).max().getAsInt();
        System.out.println(Arrays.toString(dp));

        // If all elements are -1, there are no 0s in the array
        // In this case, return 0 as there is no subarray of 0s
        return (maxSum > 0) ? maxSum : 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1};
        int result = maxZeroSubarray(nums);
        System.out.println("Maximum subarray of 0s length: " + result);
    }

}

package com.sai;

public class MaximumProductSubarray {

//    the maximum product will always lie either from the starting of the array or from the end of the array.

    static int maxProduct(int[] nums) {
        int ans, prevMin, prevMax;
        ans = prevMin = prevMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mini = prevMin * nums[i];
            int maxi = prevMax * nums[i];
            prevMin = Math.min(nums[i], Math.min(mini, maxi));
            prevMax = Math.max(nums[i], Math.max(mini, maxi));
            ans = Math.max(ans, prevMax);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4})); // 6
    }

}





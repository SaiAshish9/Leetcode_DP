package org.dp;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int n = height.length;

        if (n == 0) {
            return 0;
        }

        int[] ldp = new int[n];
        int[] rdp = new int[n];

        // calculate the max height to the left of each element
        ldp[0] = height[0];
        for (int i = 1; i < n; i++) {
            ldp[i] = Math.max(ldp[i - 1], height[i]);
        }

        // calculate the max height to the right of each element
        rdp[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rdp[i] = Math.max(rdp[i + 1], height[i]);
        }

        int trappedWater = 0;

        // calculate the trapped water at each position
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(ldp[i], rdp[i]) - height[i];
        }

        return trappedWater;
    }

}

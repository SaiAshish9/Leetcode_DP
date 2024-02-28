package com.sai;

import java.util.Arrays;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int max1 = 0;
        int left[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (max1 < height[i]) {
                max1 = height[i];
            }
            left[i] = max1;
        }
        int max2 = 0;
        int right[] = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            if (max2 < height[i]) {
                max2 = height[i];
            }
            right[i] = max2;
        }
        int trap = 0;
        for (int i = 0; i < height.length; i++) {
            trap += Math.min(left[i], right[i]) - height[i];
        }
        System.out.println();
        System.out.println();
        System.out.println("left");
        System.out.println(Arrays.toString(left));
        System.out.println();
        System.out.println("right");
        System.out.println(Arrays.toString(right));
        System.out.println();
        System.out.println();
        return trap;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 0, 2})); // 2
    }
}





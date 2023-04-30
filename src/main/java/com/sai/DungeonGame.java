package com.sai;

import java.util.Arrays;

public class DungeonGame {

    static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 1;
        for (int i = m - 1; i >= 0; --i)
            for (int j = n - 1; j >= 0; --j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) - dungeon[i][j];
                dp[j] = Math.max(dp[j], 1);
            }
        System.out.println();
        System.out.println(Arrays.toString(dp));
        System.out.println();
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        })); //  7
    }

}



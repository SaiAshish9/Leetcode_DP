package org.dp;

import java.util.Arrays;

public class Triangle {

//dp[i][j] represents the minimum path sum from the current position (i, j) to the bottom of the triangle.
    static int minimumTotal(int[][] dp) {
        for (int i = dp.length - 2; i >= 0; --i)
            for (int j = 0; j <= i; ++j)
                dp[i][j] += Math.min(dp[i + 1][j],
                        dp[i + 1][j + 1]);
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(new int[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        }));
        // 11
    }

}

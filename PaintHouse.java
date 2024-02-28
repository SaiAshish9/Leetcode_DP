package com.sai;

import java.util.Arrays;

public class PaintHouse {

    public static int minCost(int[][] costs) {
        int len = costs.length;
        if (costs != null && len == 0)
            return 0;

        int[][] dp = costs;
        // dp[i][j], for house-i, three colors j (0 or 1 or 2)

        // no need dp[m+1][n+1], just i=1 is good enough
        for (int i = 1; i < len; i++) {
            dp[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        }));
//        10
//        Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
//             Minimum cost: 2 + 5 + 3 = 10.
    }

}





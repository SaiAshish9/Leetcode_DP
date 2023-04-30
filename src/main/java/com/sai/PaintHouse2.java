package com.sai;

import java.util.Arrays;

public class PaintHouse2 {

    public static int minCost(int[][] costs) {
        if (costs != null && costs.length == 0) {
            return 0;
        }
        int[][] dp = costs;
        int min1 = -1, min2 = -1;
        for (int i = 0; i < dp.length; i++) {
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < dp[i].length; j++) {
                if (j != last1) {
                    dp[i][j] += last1 < 0 ? 0 : dp[i - 1][last1];
                } else {
                    dp[i][j] += last2 < 0 ? 0 : dp[i - 1][last2];
                }

                if (min1 < 0 || dp[i][j] < dp[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || dp[i][j] < dp[i][min2]) {
                    min2 = j;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return dp[dp.length - 1][min1];
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
                {1, 5, 3},
                {2, 9, 4}
        })); //  5
//  Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
//  Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
    }

}




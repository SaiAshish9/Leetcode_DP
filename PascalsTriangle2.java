package org.dp;

import java.util.Arrays;

public class PascalsTriangle2 {

//    dp[i] corresponds to a specific value in the current
//    row of Pascal's Triangle being computed using dynamic programming.

    static int[] getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < rowIndex + 1; ++i)
            for (int j = 1; j < i; ++j)
                dp[i - j] += dp[i - j - 1];
        return dp;
    }

    public static void main(String[] args) {

    }

}

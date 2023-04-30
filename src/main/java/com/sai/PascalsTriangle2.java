package com.sai;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {

    static int[] getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < rowIndex + 1; ++i)
            for (int j = 1; j < i; ++j)
                dp[i - j] += dp[i - j - 1];
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRow(3)));
//        [1, 3, 3, 1]
    }

}



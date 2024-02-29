package org.dp;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static List<int[]> generate(int numRows) {
        int[][] dp = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            int[] row = new int[i + 1];
            row[0] = 1; // first ele
            row[i] = 1; // last ele
            for (int j = 1; j < i; j++) {
                row[j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
            dp[i] = row;
        }
//        dp[i]: Represents the i-th row of Pascal's Triangle.
        return Arrays.asList(dp);
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }

}

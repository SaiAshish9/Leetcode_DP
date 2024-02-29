package org.dp;

import java.util.Arrays;

public class EditDistance {


    //  dp[i][j] represents the minimum number of operations (edits) required to transform the substring word1[0...i-1] to the substring word2[0...j-1].
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], // replace
                            Math.min(dp[i - 1][j], // remove
                                    dp[i][j - 1] // insert
                            )) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros")); // 3
    }

}

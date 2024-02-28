package com.sai;

import java.util.Arrays;
import java.util.List;

public class EditDistance {

    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            dp[i][0] = i;
        for (int j = 1; j <= n; ++j)
            dp[0][j] = j;
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        List<String> x = Arrays.asList("r", "o", "s");
        System.out.println();
        System.out.println();
        System.out.print("      ");
        x.stream().forEach(y -> System.out.print(y + "      "));
        System.out.println();
        System.out.println();
        List<String> y = Arrays.asList("h", "o", "r", "s", "e");
        for (int row = 0; row < m; row++) {
            System.out.print(y.get(row) + "     ");
            for (int ind = 0; ind < n; ind++) {
                System.out.print(dp[row][ind] + "      ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros")); // 3
    }

}



package com.sai;

import java.util.Arrays;
import java.util.List;

public class RegularExpressionMatching {

    /*
A regular expression consists of:

Letters A-Z
Numbers 0-9
'*': Matches 0 or more characters
'.': Matches one character
    */

    public static void matchesDP(String S, String R) {
        int m = S.length();
        int n = R.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == R.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (R.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (R.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        List<String> x = Arrays.asList(" ", "G", "*", "T", "*", "S");
        System.out.println();
        System.out.println();
        System.out.print("      ");
        x.stream().forEach(y -> System.out.print(y + "      "));
        System.out.println();
        System.out.println();
        List<String> y = Arrays.asList(" ", "G", "R", "E", "A", "T", "S");
        for (int row = 0; row < dp.length; row++) {
            System.out.print(y.get(row) + "   ");
            for (int ind = 0; ind < dp[row].length; ind++) {
                System.out.print(dp[row][ind] + (dp[row][ind] ? "   " : "  "));
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        matchesDP("GREATS", "G*T*S");
    }
}

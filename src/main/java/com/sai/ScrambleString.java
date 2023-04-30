package com.sai;

import java.util.Arrays;

public class ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        boolean[][][] dp = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[1][i][j] = true;
                }
            }
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    for (int k = 1; k < l; k++) {
                        if ((dp[k][i][j] && dp[l - k][i + k][j + k]) ||
                                (dp[k][i][j + l - k] && dp[l - k][i + k][j])) {
                            dp[l][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return dp[n][0][0];
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat")); // true
    }

}




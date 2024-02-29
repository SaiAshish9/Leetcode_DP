package org.dp;

import java.util.Arrays;

public class ScrambleString {

   // dp[i][j][len]: represents whether the substring of length len starting from index i in s1 and the substring of length len starting from index j in s2 are scrambled strings.
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        // strings of length 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j][1] = true;
                }
            }
        }

        // longer substrings
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        if ((dp[i][j][k] && dp[i + k][j + k][len - k]) // without swap
                                || (dp[i][j + len - k][k] && dp[i + k][j][len - k]) // with swap
                        ) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp)
                .replaceAll("]]", "]\n]")
                .replaceAll("\\[\\[", "[\n[")
                .replaceAll("\\[\\[", "[\n[")
                .replaceAll("],", "],\n")
                .replaceAll("]]", "]\n]")
        );
        return dp[0][0][n];
    }

        public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat")); // true
    }
    //    O(n^4)

}

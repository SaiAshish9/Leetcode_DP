package org.dp;

import java.util.Arrays;

public class REM {

    /*
      dp[i][j] will return true if the string S[0 : i] matches with a regular expression R[0 : j]
    */
    public boolean isMatch(String s, String r) {
        int m = s.length();
        int n = r.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else if (r.charAt(j - 1) == '.') dp[i][j] = dp[i - 1][j - 1];
                else if (r.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp).replaceAll("],", "],\n"));
        return dp[m][n];
    }
//    O(n^2)

}

package org.dp;

import java.util.Arrays;

public class DistinctSubsequences {

    static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; ++i)
            for (int j = n; j >= 1; --j)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] += dp[j - 1];
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit")); // 3
    }

//    dp[j]: Represents the number of distinct subsequences of the first j characters
//    of string t that can be found in the first i characters of string s.
//    [1, 1, 1, 3, 3, 3, 3]

}

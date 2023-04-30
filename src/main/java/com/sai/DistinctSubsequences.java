package com.sai;

import java.util.Arrays;

class DistinctSubsequences {

    static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; ++i)
            for (int j = n; j >= 1; --j)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] += dp[j - 1];
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit")); // 3
    }

}



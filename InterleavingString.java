package com.sai;

public class InterleavingString {

    static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[] dp = new boolean[n + 1];
        // dp[n] indicates whether it's possible to form s3 by interleaving characters from s1 and 
        // first n characters from s2.
        for (int i = 0; i <= m; ++i)
            for (int j = 0; j <= n; ++j)
                if (i == 0 && j == 0)
                    dp[j] = true;
                else if (i == 0)
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                else if (j == 0)
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                else
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                            dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
    }

}




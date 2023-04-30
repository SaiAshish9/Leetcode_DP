package com.sai;

public class DecodeWays {

    static boolean isSafe(char c1) {
        return c1 != '0';
    }

    static boolean isSafe(char c1, char c2) {
        return c1 == '1' || (c1 == '2' && c2 <= '6');
    }

    static int numDecodings(String s1) {
        int n = s1.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        char[] s = s1.toCharArray();
        if (isSafe(s[n - 1])) dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            if (isSafe(s[i]))
                dp[i] += dp[i + 1];
            if (isSafe(s[i], s[i + 1]))
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12")); // 2
    }

}



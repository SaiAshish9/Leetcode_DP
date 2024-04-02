package org.dp;

import java.util.Arrays;

public class DecodeWays {

//i: Represents the starting index of the substring in the input string s1.
//dp[i]: Represents the number of ways to decode the substring starting from index i until the end of the string.
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
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12")); // 2
    }
    // "12" could be decoded as "AB" (1 2) or "L" (12).
    // Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//    [2, 1, 1]

}

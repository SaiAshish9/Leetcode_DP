package org.dp;

import java.util.Arrays;

public class LongestValidParentheses {

    // dp[i] := Length of the longest valid parentheses substring of s1[1..i]
    public static int longestValidParentheses(String s) {
        String s1 = ")" + s;
        int n = s1.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s1.charAt(i) == ')' && s1.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()(()()()()"));
    }
//  O(n)

}

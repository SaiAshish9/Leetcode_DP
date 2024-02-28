package com.sai;

import java.util.Arrays;

/**
 * Hello world!
 */
public class LongestPalindromicSubstring {

    static boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    static void bruteForce(String s) {
        String res = "";
        int maxLen = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i >= maxLen) {
                    String substr = s.substring(i, j);
                    if (isPalindrome(substr)) {
                        int l = substr.length();
                        if (l > maxLen) {
                            maxLen = l;
                            res = substr;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    static void dynamicProgramming(String s) {
        int n = s.length();
        int x = 0, y = 0, max = Integer.MIN_VALUE;
        boolean dp[][] = new boolean[n][n];
//        dp[i][j] = whether the substring from index i to j is a palindrome or not
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j <= n - 1; j++) {
//                i==j
//                Every single character of a string is a palindrome. Therefore dp[i][j] is true.
                if (i == j)
                    dp[i][j] = true;
//                j-i=1
//                We're checking two characters at a time, if s[i]==s[j], then dp[i][j] is true.
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) dp[i][j] = true;
                    else
//                j-i>=2 => j >= 2 + i
//                Consider "aba" s[0]=s[2], therefore dp[i][j] will be true.
//                If s[i]==s[j], but j-i>=2, dp[i][j] = dp[i+1][j-1].
//                Now the i+1,j-1 coordinates are literally eliminating the first and last characters
//                Since they are already the same, we want to know if the string without them is still
//                a palindrome or no? This result will in turn be any of the above cases or this case, nevertheless,
//                the result has already been calculated.
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i >= max) {
                    max = j - i;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(s.substring(x, y - x + 1));
    }

    public static void main(String[] args) {
        String s = "babad";
        bruteForce(s);
        dynamicProgramming(s);
    }
}

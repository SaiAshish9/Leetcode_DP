package org.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LPS5 {

    public boolean isPalindrome(String s) {
        // two pointers
        int left = 0, right = s.length() - 1;
        while (left != right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String res = "";
        int maxL = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i >= maxL) {
                    String substr = s.substring(i, j);
                    if (isPalindrome(substr)) {
                        int len = substr.length();
                        if (len > maxL) {
                            maxL = len;
                            res = substr;
                        }
                    }
                }
            }
        }
        return res;
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

    public String longestPalindromeManachers(String string) {
        string = updatedString(string);
        int n = string.length();
        int[] lps = new int[n];
        int C = 0; // center
        int R = 0; // range
        for (int i = 0; i < n; i++) {
            int invertedMirror = 2 * C - i;
            if (R > i) lps[i] = Math.min(R - i, lps[invertedMirror]);
            else lps[i] = 0;
            try {
                while (string.charAt(i + 1 + lps[i]) == string.charAt(i - 1 - lps[i])) lps[i]++;
            } catch (Exception e) {
            }
            if (i + lps[i] > R) {
                C = i;
                R = i + lps[i];
            }
        }
        int r = Arrays.stream(lps).max().getAsInt();
        ArrayList<Integer> lps_list = new ArrayList<>();
        for (int i = 0; i < lps.length; i++)
            lps_list.add(lps[i]);
        int c = lps_list.indexOf(r);
        return string.substring(c - r, c + r).replace("#", "");
    }


    public String updatedString(String string) {
        StringBuilder newString = new StringBuilder();
        for (char c : string.toCharArray()) newString.append(c).append("#");
        return newString.toString();
    }
//    O(n)

}

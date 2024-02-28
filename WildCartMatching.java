package com.sai;

import java.util.Arrays;

public class WildCartMatching {

    public static void print(char dp[][], int m, int n){
        System.out.println();
        System.out.println();
        for (int row = 0; row <= m; row++) {
            for (int ind = 0; ind <= n; ind++) {
                System.out.print(dp[row][ind] + "   ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void print(boolean dp[][], int m, int n){
        System.out.println();
        System.out.println();
        for (int row = 0; row <= m; row++) {
            for (int ind = 0; ind <= n; ind++) {
                System.out.print(dp[row][ind] + (dp[row][ind] ? "   " : "  "));
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void print(int dp[][], int m, int n){
        System.out.println();
        System.out.println();
        for (int row = 0; row <= m; row++) {
            for (int ind = 0; ind <= n; ind++) {
                System.out.print(dp[row][ind] + "   ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        isMatch("aa", "a"); // false
    }
}



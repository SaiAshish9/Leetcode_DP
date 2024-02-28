package com.sai;

import java.util.Arrays;

public class PalindromePartitioning2 {

    static int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n];
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j < i + 1; j++) {
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) min = 0;
                    else min = Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        System.out.println();
        System.out.println();
        System.out.println(Arrays.toString(cut));
        System.out.println();
        System.out.println();
        return cut[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab")); // 1
    }

}



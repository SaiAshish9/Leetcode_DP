package org.dp;

import java.util.Arrays;

public class MCL {

    private static int mcl(int[][] envelopes) {
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(mcl(new int[][]{
                {5, 24},
                {39, 60},
                {27, 40},
                {50, 90}
        }));
    }

}

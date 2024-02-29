package org.dp;

import java.util.Arrays;

public class RussianDollEnvelopes {

    private static int russianDollEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] &&
                        envelopes[i][1] > envelopes[j][1]
                        && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(russianDollEnvelopes(new int[][]{
                {4, 3},
                {5, 3},
                {5, 6},
                {1, 2}
        }));
    }


}

package com.sai;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCoolDown {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int ind = n - 1; ind >= 0; ind--) {
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
            dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
        }
        System.out.println();
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        System.out.println();
        return dp[0][1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
    }

}



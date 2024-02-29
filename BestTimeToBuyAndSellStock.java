package org.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

//  dp[i] represents the minimum price of the stock among the prices encountered up to index i in the prices array.

    public static int maxProfit(int[] prices) {
        int res = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
        }
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, prices[i] - dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
//      [7, 1, 1, 1, 1, 1]
    }

}

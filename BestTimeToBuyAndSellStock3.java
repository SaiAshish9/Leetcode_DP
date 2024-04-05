package org.dp;

public class BestTimeToBuyAndSellStock3 {

// dp[i][j] represents the maximum profit at the end of day j considering at most i transactions.
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[3][n];

        for (int i = 1; i <= 2; i++) {
            int maxDiff = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[2][n - 1];
    }

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


// leftProfit[i] stores the maximum profit that can be obtained by making a single transaction on or before day i.
// rightProfit[i] stores the maximum profit that can be obtained by making a single transaction on or after day i.

 public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];
        
        // Calculate maximum profit from left to right
        int minPrice = prices[0];
        leftProfit[0] = 0;
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }
        
        // Calculate maximum profit from right to left
        int maxPrice = prices[n - 1];
        rightProfit[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }
        
        int maxProfit = 0;
        // Find the maximum profit by combining left and right profits
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4})); // 6
        // Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
    }

}

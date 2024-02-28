package com.sai;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {

    static int maxProfit(int k, int[] prices) {
        if (k >= (prices.length / 2)) {
            int sell = 0;
            int hold = Integer.MIN_VALUE;
            for (int p : prices) {
                sell = Math.max(sell, hold + p);
                hold = Math.max(hold, sell - p);
            }
            return sell;
        }
        int[] sell = new int[k + 1];
        int[] hold = new int[k + 1];
        Arrays.fill(hold, Integer.MAX_VALUE);
        for (int price : prices)
            for (int i = k; i > 0; --i) {
                sell[i] = Math.max(sell[i], hold[i] + price);
                hold[i] = Math.max(hold[i], sell[i - 1] - price);
            }
        System.out.println();
        System.out.println("sell");
        System.out.println(Arrays.toString(sell));
        System.out.println();
        System.out.println("hold");
        System.out.println(Arrays.toString(hold));
        System.out.println();
        return sell[k];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1})); // 2
    }

}



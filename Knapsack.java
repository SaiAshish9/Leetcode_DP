package org.dp;

public class Knapsack {

//function knapSack(val, wt, W) {
//    const n = val.length;
//    const dp = Array.from(Array(n + 1), () => Array(W + 1).fill(-1));
//    for (let i = 0; i <= n; i++) {
//        for (let w = 0; w <= W; w++) {
//            if (i == 0 || w == 0) {
//                dp[i][w] = 0;
//            } else if (wt[i - 1] <= w)
//                dp[i][w] = Math.max(
//                    val[i - 1] + dp[i - 1][w - wt[i - 1]],
//                );
//            else dp[i][w] = dp[i - 1][w];
//        }
//    }
//    console.log("lookup table:")
//    console.log(dp)
//    return dp[n][W];
//}

}

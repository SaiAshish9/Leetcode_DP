package com.sai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {

    static int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> a = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        a.add(0, 1);
        a.add(1);
        int[][] dp = new int[n + 2][n + 2];
        for (int d = 0; d < n; ++d)
            for (int i = 1; i < n - d + 1; ++i) {
                int j = i + d;
                for (int k = i; k <= j; ++k)
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + dp[k + 1][j] + a.get(i - 1) * a.get(k) * a.get(j + 1));
            }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8})); // 167
    }

}




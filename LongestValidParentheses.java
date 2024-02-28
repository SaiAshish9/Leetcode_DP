package com.sai;

import java.util.Arrays;
import java.util.List;

public class LongestValidParentheses {
    static void lvp(String s) {
        String s2 = ")" + s;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        for (int i = 1; i < n; ++i)
            if (s2.charAt(i) == ')' && s2.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
        System.out.println();
        System.out.println();
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.asList(s.split("")).toString());
        System.out.println();
        System.out.println();
//        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    public static void main(String[] args) {
        lvp("()()()("); // 6
    }
}

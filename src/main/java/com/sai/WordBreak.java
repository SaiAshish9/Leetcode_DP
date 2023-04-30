package com.sai;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    static boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i)
            for (int j = 0; j < i; ++j)
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode",
                new HashSet<>(Arrays.asList("leet", "code"))
        ));
    }

}

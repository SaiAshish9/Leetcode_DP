package org.dp;

import java.util.*;

public class WordBreak2 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet set = new HashSet();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        List result = new ArrayList();
        dfs("", result, 0, s, dp, set);
        System.out.println(Arrays.toString(dp));
        return result;
    }

    static void dfs(String path, List<String> result, int index, String s, boolean[] dp, Set set) {
        if (index == s.length()) {
            result.add(path);
            return;
        }
        for (int j = index; j <= s.length(); j++) {
            if (dp[index] && set.contains(s.substring(index, j))) {
                dp[j] = true;
                String temp = path;
                path += s.substring(index, j);
                if (j != s.length()) path += " ";
                dfs(path, result, j, s, dp, set);
                path = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
//        [cat sand dog, cats and dog]
    }

}

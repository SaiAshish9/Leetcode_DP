package org.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private List<String> generateParentheses(int n) {

        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                List<String> curr = new ArrayList<>();
                for (String x : dp.get(j)) {

                    for (String y : dp.get(i - j - 1)) {
                        curr.add("(" + x + ")" + y);
                    }
                }
                dp.get(i).addAll(curr);
            }
        }

        System.out.println(dp);
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParentheses(3));
    }
//    Time: O(n * Cat(n)), where Cat represents the time complexity of Catalan numbers


}

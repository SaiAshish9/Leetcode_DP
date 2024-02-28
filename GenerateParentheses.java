package com.sai;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - j - 1);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        System.out.println();
        System.out.println();
        for (List<String> str : dp) {
            for (String s : str) {
                if (s.equals("()()"))
                    System.out.print(s + "     ");
                else if (s.equals(""))
                    System.out.print("\"\"");
                else
                    System.out.print(s + "   ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}





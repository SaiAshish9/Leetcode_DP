package com.sai;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static List<Integer> fun(String str) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '*' || ch == '-' || ch == '+') {
                List<Integer> left = fun(str.substring(0, i));
                List<Integer> right = fun(str.substring(i + 1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (ch == '+') ans.add(left.get(j) + right.get(k));
                        else if (ch == '-') ans.add(left.get(j) - right.get(k));
                        else if (ch == '*') ans.add(left.get(j) * right.get(k));
                    }
                }
            }
        }
        if (ans.size() == 0) ans.add(Integer.parseInt(str));
        return ans;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        return fun(expression);
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    } // [2, 0]

}





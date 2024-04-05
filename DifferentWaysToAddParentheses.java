package com.sai;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                
                List<Integer> part1Results = diffWaysToCompute(part1);
                List<Integer> part2Results = diffWaysToCompute(part2);
                
                for (int num1 : part1Results) {
                    for (int num2 : part2Results) {
                        int res = 0;
                        switch (c) {
                            case '+':
                                res = num1 + num2;
                                break;
                            case '-':
                                res = num1 - num2;
                                break;
                            case '*':
                                res = num1 * num2;
                                break;
                        }
                        result.add(res);
                    }
                }
            }
        }
        
        if (result.isEmpty()) { // Base case: if the input contains only digits
            result.add(Integer.valueOf(input));
        }
        
        return result;
    }
    

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





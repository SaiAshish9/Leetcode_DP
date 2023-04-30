package com.sai;

import java.util.HashMap;
import java.util.Map;

public class FlipGame2 {

    private static Map<String, Boolean> memo = new HashMap<>();

    public static boolean canWin(String currentState) {
        if (memo.containsKey(currentState))
            memo.get(currentState);
        // If any of currentState[i:i + 2] == "++" and your friend can't win after
        // Changing currentState[i:i + 2] to "--" (or "-"), then you can win
        for (int i = 0; i + 1 < currentState.length(); ++i)
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+' &&
                    !canWin(currentState.substring(0, i) + "-" + currentState.substring(i + 2))) {
                memo.put(currentState, true);
                return true;
            }
        memo.put(currentState, false);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canWin("++++")); // true
        System.out.println(memo);
    }

}



package com.sai;

import java.util.Arrays;

public class NumberOfDigitOne {

    private static int[] getLimitArray(int n) {
        String num = n + "";
        int[] limits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            limits[i] = Character.getNumericValue(num.charAt(i));
        }
        return limits;
    }
// Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//  O(log n).
public int countDigitOne(int n) {
        if (n <= 0) return 0;

        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }

        return count;
    }
 
    public static int countDigitOne(int n) {
        int[] limits = getLimitArray(n);
        int[][][] dp = new int[limits.length + 1][2][limits.length + 2];

        for (int index = limits.length; index >= 0; index--) {
            for (int flag = 0; flag <= 1; flag++) {
                for (int count = limits.length; count >= 0; count--) {
                    if (index == limits.length) {
                        dp[index][flag][count] = count;
                    } else {
                        int result = 0;
                        if (flag == 1) {
                            for (int i = 0; i <= limits[index]; i++) {
                                int newCount = count;
                                if (i == 1)
                                    newCount++;
                                if (i == limits[index]) {
                                    result += dp[index + 1][1][newCount];
                                } else {
                                    result += dp[index + 1][0][newCount];
                                }
                            }
                        } else {
                            for (int i = 0; i <= 9; i++) {
                                int newCount = count;
                                if (i == 1)
                                    newCount++;
                                result += dp[index + 1][0][newCount];
                            }
                        }
                        dp[index][flag][count] = result;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp).replace("],", "],\n"));
        return dp[0][1][0];
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13)); // 6
    }

}



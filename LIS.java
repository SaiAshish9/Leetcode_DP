package org.dp;

import java.util.Arrays;

public class LIS {

    private static int lis(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1;i<n;i++){
          for(int j=0;j<i;j++){
              if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                 dp[i] = dp[j] + 1;
              }
          }
        }

        return Arrays.stream(dp).max().getAsInt();
     }

    public static void main(String[] args) {
        System.out.println(lis(new int[]{0, 22, 33, 41, 60}));
    }

}

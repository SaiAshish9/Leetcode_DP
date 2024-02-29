package org.dp;

import java.util.*;
import java.util.Arrays;

public class S {

    public static int maxDistinctElements(List<Integer> a, List<Integer> b, List<Integer> n, int k) {
        // Step 1: Convert Lists to arrays and sort arrays a and b
        Integer[] aArray = a.toArray(new Integer[0]);
        Integer[] bArray = b.toArray(new Integer[0]);
        Integer[] nArray = n.toArray(new Integer[0]);

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        // Step 2: Initialize variables
        int count = 0;
        int i = 0;

        // Step 3: Iterate through each element in array a
        while (i < nArray.length && k > 0) {
            // Check if swapping increases the value in array a
            if (aArray[i] < bArray[nArray.length - i - 1]) {
                aArray[i] = bArray[nArray.length - i - 1];
                count++;
                k--;
            }
            i++;
        }

        // Step 4: Update the count of distinct elements in array a
        Set<Integer> distinctSet = new HashSet<>(Arrays.asList(aArray).subList(i, nArray.length));
        return count + distinctSet.size();
    }


    public static void main(String[] args) {
       int n = 5;
        int[] a = {2,3,3,2,2};
//        {1, 1, 4, 5, 5};
        int[] b = {1,3,2,4,1};
//        {4, 4, 3, 1, 5};
        int k = 2;

//        int output = maxDistinctElements(a, b, n, k);
//        System.out.println("Maximum distinct elements after " + k + " operations: " + output);
    }
}



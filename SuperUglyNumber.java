package com.sai;

import java.util.Arrays;

public class SuperUglyNumber {

    static int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] indices = new int[k];
        // This array will keep track of the indices of the prime numbers to be multiplied with the current ugly number.
        int[] uglyNums = new int[n];
        //  This array will store the super ugly numbers.
        uglyNums[0] = 1;
        for (int i = 1; i < n; ++i) {
            int[] nexts = new int[k];
            //  This array will store the next possible super ugly numbers by multiplying the current ugly numbers with each prime number.
            for (int j = 0; j < k; ++j)
                nexts[j] = uglyNums[indices[j]] * primes[j];
            int next = Arrays.stream(nexts).min().getAsInt();
            for (int j = 0; j < k; ++j)
                if (next == nexts[j])
                    ++indices[j];
            uglyNums[i] = next;
        }
        System.out.println();
        System.out.println("Ugly Nums");
        System.out.println(Arrays.toString(uglyNums));
        System.out.println();
        System.out.println("Indices");
        System.out.println(Arrays.toString(indices));
        System.out.println();
        return uglyNums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19})); // 32
    }
}



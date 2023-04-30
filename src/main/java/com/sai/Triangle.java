package com.sai;

import java.util.Arrays;

public class Triangle {

    static int minimumTotal(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; --i)
            for (int j = 0; j <= i; ++j)
                triangle[i][j] += Math.min(triangle[i + 1][j],
                        triangle[i + 1][j + 1]);
        System.out.println();
        System.out.println();
        System.out.println(Arrays.deepToString(triangle).replace("],", "],\n"));
        System.out.println();
        System.out.println();
        return triangle[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(new int[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        }));
        // 11
    }
}


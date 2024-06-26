package org.dp;

public class UniqueBinarySearchTrees {

//  dp[i] represents the number of unique binary search trees that can be formed with i nodes.
    static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i)
            for (int j = 0; j < i; ++j)
                dp[i] += dp[j] * dp[i - j - 1];
        return dp[n];
    }

// Multiplying dp[j] with dp[i - j - 1] gives the 
// total number of unique binary search trees that can be 
// formed with j nodes on the left subtree and i - j - 1 
// nodes on the right subtree, considering all possible 
// combinations of left and right subtrees.

    public static void main(String[] args) {
        System.out.println(numTrees(3)); // 5
    }


}

package org.dp;

import java.util.HashMap;

// Recursion + Memoization
public class BinaryTreeMaxPathSum {

    private int maxSum = Integer.MIN_VALUE;
    private HashMap<TreeNode, Integer> memo = new HashMap<>();


//    static int res = Integer.MIN_VALUE;
//    public static int maxPathSum(TreeNode root) {
//        solve(root);
//        return res;
//    }
//    public static int solve(TreeNode root) {
//        if (root == null) return 0;
//        int left = solve(root.left);
//        int right = solve(root.right);
//        int temp = Math.max(Math.max(left, right) + root.val, root.val);
//        int ans = Math.max(temp, left + right + root.val);
//        res = Math.max(ans, res);
//        return temp;
//    }

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        // Calculate the maximum sum for the left and right subtrees
        int leftSum = Math.max(0, calculateMaxPathSum(node.left));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right));
        // Calculate the maximum sum including the current node for the upper levels of recursion
        int currentMax = Math.max(leftSum, rightSum) + node.val;
        // Memoize the result for the current node
        memo.put(node, currentMax);
        // Update the global maximum path sum
        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
        return currentMax;
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();

        // Example usage
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));
    }
}

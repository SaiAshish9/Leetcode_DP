package com.sai;

public class BinaryTreeMaximumPathSum {

    static int res = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }

    public static int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left); // left subtree
        int right = solve(root.right); // right subtree
        int temp = Math.max(Math.max(left, right) + root.val, root.val); // max of left and right
        int ans = Math.max(temp, left + right + root.val);
        res = Math.max(ans, res);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        System.out.println(maxPathSum(t)); // 6
    }

}



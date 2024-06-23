package com.sai;

public class BinaryTreeMaximumPathSum {

    private static int maxSum;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data) {
            this.val = data;
            this.left = this.right = null;
        }
    }

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private static int maxGain(TreeNode node) {
        if (node != null) {
            int left = Math.max(maxGain(node.left), 0);
            int right = Math.max(maxGain(node.right), 0);
            int curr = node.val + left + right;
            maxSum = Math.max(maxSum, curr);
            return node.val + Math.max(left, right);
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        System.out.println(maxPathSum(t)); // 6
    }

}



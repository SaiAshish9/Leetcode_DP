package com.sai;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<>();
        if (n == 0) return result[0];
        result[0].add(null);
        for (int i = 1; i <= n; i++) {
            result[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<TreeNode> lefts = result[j];
                List<TreeNode> rights = result[i - 1 - j];
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = copyTree(right, j + 1);
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode copyTree(TreeNode root, int offset) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val + offset);
        node.left = copyTree(root.left, offset);
        node.right = copyTree(root.right, offset);
        return node;
    }

    static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void print(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            preOrder(new TreeNode(node.val, node.left, node.right));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = new UniqueBinarySearchTrees2().generateTrees(3);
        new UniqueBinarySearchTrees2().print(nodes);
    }
}




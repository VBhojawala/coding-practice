package binaryTree.general;

import binaryTree.TreeNode;

public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
       return height(root) >= 0 ;
    }

    private int height(TreeNode root){
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;

        return 1 + Math.max(left, right);
    }
}

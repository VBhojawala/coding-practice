package binaryTree.general;

import binaryTree.TreeNode;

public class SumRootToLeave129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode root, Integer sum){
        if (root == null)
            return 0;

        sum = (sum * 10) + root.val;

        if (root.left == null && root.right == null)
            return sum;

        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);

    }
}
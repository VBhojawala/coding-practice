package binaryTree.general;

import binaryTree.TreeNode;

public class BTMaximumPathSum124 {

    private Integer max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        mps(root);
        return max;
    }

    private int mps(TreeNode root){

        if (root == null)
            return 0;

        int leftSum = Math.max(0, mps(root.left));
        int rightSum = Math.max(0, mps(root.right));

        max = Math.max(max , root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}

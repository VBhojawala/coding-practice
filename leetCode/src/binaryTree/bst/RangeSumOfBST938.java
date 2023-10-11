package binaryTree.bst;

import binaryTree.TreeNode;

public class RangeSumOfBST938 {

    private int low, high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low =low;
        this.high = high;
        return rangeSumBST(root);
    }

    private int rangeSumBST(TreeNode root){
        if (root == null) return 0;
        if (low <= root.val && root.val <= high)
            return root.val + rangeSumBST(root.left) + rangeSumBST(root.right);
        else if(root.val < low)
            return rangeSumBST(root.right);
        else
            return rangeSumBST(root.left);
    }
}

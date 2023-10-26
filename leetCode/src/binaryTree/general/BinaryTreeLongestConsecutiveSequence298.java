package binaryTree.general;

import binaryTree.TreeNode;

public class BinaryTreeLongestConsecutiveSequence298 {

    private int maxLength=0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int lMax = dfs(root.left) + 1;
        int rMax = dfs(root.right) + 1;
        if (root.left != null && root.left.val - root.val != 1)
            lMax = 1;
        if (root.right != null && root.right.val - root.val != 1)
            rMax = 1;
        int levelMax = Math.max(lMax, rMax);
        maxLength = Math.max(maxLength, levelMax);
        return levelMax;
    }
}

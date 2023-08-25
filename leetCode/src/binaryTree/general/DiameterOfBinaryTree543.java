package binaryTree.general;

import binaryTree.TreeNode;

public class DiameterOfBinaryTree543 {

    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, left+right);

        return 1 + Math.max(left, right);
    }
}

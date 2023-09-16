package binaryTree.general;

import binaryTree.TreeNode;

public class LongestZigZagPathInBinaryTree1372 {

    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, true, 0),
                dfs(root.right, false, 0));
    }

    private int dfs(TreeNode root, boolean isLeft, int depth){
        if (root == null) return depth;
        if (isLeft)
            return Math.max(dfs(root.right, false, depth+1), dfs(root.left, true, 0));
        return Math.max(dfs(root.left, true, depth+1), dfs(root.right, false,0));
    }
}

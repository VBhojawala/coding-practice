package binaryTree.general;

import binaryTree.TreeNode;

public class CountGoodNodesInBinaryTree1448 {

    int count;
    public int goodNodes(TreeNode root) {
        count=0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode root, int max){
        if (root == null)
            return;

        if (root.val >= max){
            max = root.val;
            count++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}

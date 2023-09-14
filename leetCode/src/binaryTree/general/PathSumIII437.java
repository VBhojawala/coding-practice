package binaryTree.general;

import binaryTree.TreeNode;

public class PathSumIII437 {
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void dfs(TreeNode root, long sum){
        if (root == null) return ;
        if (sum-root.val == 0)
             count++;
        dfs(root.left, sum-root.val);
        dfs(root.right, sum-root.val);
    }
}

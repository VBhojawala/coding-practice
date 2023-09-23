package binaryTree.general;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeNode prev = new TreeNode(0, root, null);
        while (prev.left != null){
            List<Integer> levelNodes = new ArrayList<>();
            dfs(prev.left, prev, levelNodes);
            result.add(levelNodes);
        }
        return result;
    }

    private void dfs(TreeNode root, TreeNode prev, List<Integer> levelNodes){
        if (root == null) return;

        if (root.left == null && root.right == null){
            levelNodes.add(root.val);
            if (prev.left == root) prev.left = null;
            else prev.right = null;
        }
        dfs(root.left, root, levelNodes);
        dfs(root.right, root, levelNodes);
    }
}

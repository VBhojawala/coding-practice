package binaryTree.general;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if (root ==null) return;
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }

}

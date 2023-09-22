package binaryTree.general;

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HeightOfBinaryTreeAfterSubTreeRemovalQueries2458 {

    private Map<TreeNode, Integer> map = new HashMap<>();
    private int[] d;
    public int[] treeQueries(TreeNode root, int[] queries) {
        heightOfBinaryTree(root);
        map.put(null, 0);
        d = new int[map.size()+1];
        dfs(root, -1, 0);

        int n = queries.length;
        int[] result = new int[n];

        for (int i=0; i<n; i++)
            result[i] = d[queries[i]];
        return result;
    }

    private void dfs(TreeNode root, int depth, int rest){
        if (root == null) return;
        depth++;
        d[root.val] = rest;
        dfs(root.left, depth, Math.max(rest, depth + map.get(root.right)));
        dfs(root.right, depth, Math.max(rest, depth + map.get(root.left)));
    }

    private int heightOfBinaryTree(TreeNode root){
        if (root == null) return 0;
        int left = heightOfBinaryTree(root.left);
        int right = heightOfBinaryTree(root.right);
        map.put(root, 1+ Math.max(left, right));
        return map.get(root);
    }
}

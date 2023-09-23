package binaryTree.general;

import binaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest1110 {

    private boolean[] deleteMap = new boolean[1001];
    private List<TreeNode> forest = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x : to_delete)
            deleteMap[x] = true;

        if (dfs(root) != null)
            forest.add(root);

        return forest;
    }

    private TreeNode dfs(TreeNode root){
        if (root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (!deleteMap[root.val])
            return root;

        if (root.left != null) forest.add(root.left);
        if (root.right != null) forest.add(root.right);

        return null;
    }
}

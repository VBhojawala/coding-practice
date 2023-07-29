package binaryTree.general;

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderPostOrderTraversal105 {
    private Map<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) {
            indexes.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, preorder.length);

    }
    public TreeNode buildTree(int[] preorder, int i, int j, int n){
        if (n <= 0)
            return null;

        int v = preorder[i];
        int k = indexes.get(v);
        TreeNode root = new TreeNode(v);
        root.left = buildTree(preorder, i + 1, j, k - j);
        root.right = buildTree(preorder, i + 1 + k - j, k + 1, n - k + j - 1);
        return root;
    }
}

package binaryTree.general;

import binaryTree.TreeNode;

public class SymmetricTree101 {

    public boolean isSymmetric(TreeNode root) {
        return compareSubTree(root, root);
    }

    public boolean compareSubTree(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        return compareSubTree(left.right, right.left) && compareSubTree(left.left, right.right);
    }
}

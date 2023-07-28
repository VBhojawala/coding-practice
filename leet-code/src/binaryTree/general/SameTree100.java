package binaryTree.general;

import binaryTree.TreeNode;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==q)
            return true;
        if(p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

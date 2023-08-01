package binaryTree.bst;

import binaryTree.TreeNode;

public class ValidateBinarySearchTree98 {

    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        if(!isValidBST(root.left))
            return false;

        if(prev !=null && prev >= root.val)
            return false;

        prev = root.val;

        if (!isValidBST(root.right))
            return false;

        return true;
    }
}

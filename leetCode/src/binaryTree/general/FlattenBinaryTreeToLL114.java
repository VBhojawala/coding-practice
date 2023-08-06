package binaryTree.general;

import binaryTree.TreeNode;
public class FlattenBinaryTreeToLL114 {
    public void flatten(TreeNode root) {
        convertToLL(root);
    }

    private TreeNode convertToLL(TreeNode root){
        if (root== null)
            return root;

        TreeNode leftTail = convertToLL(root.left);
        TreeNode rightTail = convertToLL(root.right);

        if (leftTail != null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightTail != null)
            return rightTail;
        if (leftTail != null)
            return leftTail;
        return root;
    }
}

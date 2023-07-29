package binaryTree.general;

import binaryTree.TreeNode;

public class CountCompleteTreeNodes222 {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if(leftDepth == rightDepth)
            return (1 << leftDepth) + countNodes(root.right);

        return(1 << rightDepth) + countNodes(root.left);

    }

    private int depth(TreeNode root){
        int count = 0;
        while (root != null){
            root= root.left;
            count++;
        }
        return count;
    }


}

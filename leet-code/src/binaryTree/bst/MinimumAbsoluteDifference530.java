package binaryTree.bst;

import binaryTree.TreeNode;

public class MinimumAbsoluteDifference530 {

    static int min = Integer.MAX_VALUE;
    static int pre = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if (root == null)
            return min;

        getMinimumDifference(root.left);
        min = Math.min(min, Math.abs(pre - root.val));
        pre = root.val;
        getMinimumDifference(root.right);

        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left2 = new TreeNode(2);
        TreeNode left1 = new TreeNode(1);
        TreeNode leftRight3 = new TreeNode(3);
        TreeNode right6 = new TreeNode(6);

        root.left=left2; root.right=right6;
        left2.left= left1; left1.right= leftRight3;

        System.out.println(getMinimumDifference(root));


    }
}

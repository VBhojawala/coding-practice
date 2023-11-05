package binaryTree.general;

import backtracking.Pair;
import binaryTree.TreeNode;

public class CountNodesEqualToAverageOfSubtree {
    private int count;
    public int averageOfSubtree(TreeNode root) {
        postorderTraversal(root);
        return count;
    }

    private Pair<Integer, Integer> postorderTraversal(TreeNode node){
        if (node == null) return new Pair<>(0,0);

        var left = postorderTraversal(node.left);
        var right = postorderTraversal(node.right);

        int nodeSum = left.getKey() + right.getKey() + node.val;
        int nodeCount = left.getValue() + right.getValue() + 1;

        if (node.val == (nodeSum / nodeCount))
            count++;

        return new Pair<>(nodeSum, nodeCount);
    }
}

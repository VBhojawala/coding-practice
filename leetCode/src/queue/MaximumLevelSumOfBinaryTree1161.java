package queue;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumLevelSumOfBinaryTree1161 {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int curLevel = 0, maxLevel = 0;
        int curSum, maxSum=Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            curLevel++; curSum=0;
            for (int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                curSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (curSum > maxSum){
                maxSum = curSum;
                maxLevel = curLevel;
            }
        }

        return maxLevel;
    }
}

package binaryTree.bfs;

import binaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CheckCompletenessOfBinaryTree958 {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null)
            queue.poll();

        return queue.isEmpty();
    }
}

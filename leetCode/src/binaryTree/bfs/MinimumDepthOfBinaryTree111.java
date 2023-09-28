package binaryTree.bfs;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int minDepth = 0;
        TreeNode curr;
        while (true){
            minDepth++;
            for(int i= queue.size(); i>0 ; i--){
                curr = queue.poll();

                if (curr.left == null && curr.right == null)
                    return minDepth;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);

            }
        }
    }
}

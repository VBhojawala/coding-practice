package binaryTree.bfs;

import binaryTree.TreeNode;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean isReverse = false;

        while (!queue.isEmpty()){
            List<Integer> levelNodes = new ArrayList<>();

            for (int i= queue.size(); i> 0; i--){
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            if (isReverse)
                Collections.reverse(levelNodes);
            isReverse = !isReverse;

            result.add(levelNodes);
        }
        return result;
    }
}

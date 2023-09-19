package binaryTree.bfs;

import binaryTree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_II107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null) return  result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> levelNodes = new ArrayList<>();
            for (int i=queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(0,levelNodes);
        }
        return result;
    }
}

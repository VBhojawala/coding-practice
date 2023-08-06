package binaryTree.bfs;

import binaryTree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root==null)
            return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            result.add(queue.peekLast().val);
            for(int i=queue.size(); i >0; i--){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return  result;
    }
}

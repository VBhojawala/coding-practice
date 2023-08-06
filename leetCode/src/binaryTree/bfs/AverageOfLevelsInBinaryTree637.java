package binaryTree.bfs;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree637 {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int n = queue.size();
            long sum = 0;
            for (int i=n; i > 0; i--){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!= null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(sum/ (n * 1.0) );
        }
        return result;
    }
}

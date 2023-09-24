package binaryTree.general;

import binaryTree.TreeNode;

import java.util.*;
public class BinaryTreeVerticalOrderTraversal314 {

    class Pair{
        TreeNode node;
        Integer column;

        public Pair(TreeNode node, Integer column) {
            this.node = node;
            this.column = column;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null) return result;

        Map<Integer, List<Integer>> columTable = new HashMap<>();

        Queue<Pair> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair(root, column));
        int minColumn=0, maxColumn =0;

        while (!queue.isEmpty()){
            Pair p = queue.poll();
            root = p.node; column = p.column;

            columTable.computeIfAbsent(column, e -> new ArrayList<>()).add(root.val);
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (root.left != null) queue.offer(new Pair(root.left, column-1));
            if (root.right != null) queue.offer(new Pair(root.right, column + 1));
        }

        for (int i=minColumn; i< maxColumn +1; i++)
            result.add(columTable.get(i));

        return result;
    }
}

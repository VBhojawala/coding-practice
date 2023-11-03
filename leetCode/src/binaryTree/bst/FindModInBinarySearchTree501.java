package binaryTree.bst;

import binaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class FindModInBinarySearchTree501 {

    private int currentVal = 0, currentCount =0, maxCount =0;
    private List<Integer> result;
    public int[] findMode(TreeNode root) {
        result = new ArrayList<>();
        inorderTraversal(root);
        int[] mode = new int[result.size()];
        for (int i=0;i < result.size(); i++)
            mode[i] = result.get(i);
        return mode;
    }

    private void inorderTraversal(TreeNode node){
        if (node == null) return;

        inorderTraversal(node.left);

        currentCount = (node.val == currentVal) ? currentCount + 1 : 1;
        if (currentCount == maxCount) {
            result.add(node.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            result.clear();
            result.add(node.val);
        }
        currentVal = node.val;

        inorderTraversal(node.right);
    }
}

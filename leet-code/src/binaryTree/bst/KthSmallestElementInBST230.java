package binaryTree.bst;

import binaryTree.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root !=null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                if(--k == 0)
                    return node.val;
                root = node.right;
            }
        }
        return 0;
    }
}

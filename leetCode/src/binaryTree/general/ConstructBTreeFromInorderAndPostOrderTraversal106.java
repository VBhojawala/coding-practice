package binaryTree.general;

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromInorderAndPostOrderTraversal106 {
    private Map<Integer, Integer> inorderIndex = new HashMap<>();
    int[] inoder, postorder;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; ++i)
            inorderIndex.put(inorder[i], i);

        this.inoder = inorder;
        this.postorder = postorder;
        postIndex= postorder.length - 1;

        return buildTree(0, postorder.length-1);
    }

    private TreeNode buildTree(int left, int right){
        if(left > right)
            return null;

        TreeNode root = new TreeNode(postorder[postIndex--]);

        int mid = inorderIndex.get(root.val);
        root.right = buildTree(mid+1, right);
        root.left = buildTree(left, mid -1);

        return root;
    }

    public static void main(String[] args) {
        ConstructBTreeFromInorderAndPostOrderTraversal106 prog = new ConstructBTreeFromInorderAndPostOrderTraversal106();

        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        TreeNode root = prog.buildTree(inorder, postorder);
        System.out.println(root);

        inorder = new int[]{40,20,50,10,60,30};
        postorder = new int[]{40,50,20,60,30,10};

        root = prog.buildTree(inorder, postorder);
        System.out.println(root);
    }
}

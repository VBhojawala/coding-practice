package binaryTree.general;

import binaryTree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreorderAndInOrderTraversal105 {
    private Map<Integer, Integer> inorderIndex = new HashMap<>();
    int preIndex;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) {
            this.inorderIndex.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree( 0, inorder.length -1 );

    }

    private TreeNode buildTree(int left, int right){
        if (left > right)
            return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right)
            return root;

        int mid = inorderIndex.get(root.val);

        root.left = buildTree(left, mid-1);
        root.right = buildTree(mid+1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder ={9,3,15,20,7};
        ConstructBTFromPreorderAndInOrderTraversal105 prog = new ConstructBTFromPreorderAndInOrderTraversal105();
        TreeNode root = prog.buildTree(preorder, inorder);
        System.out.println(root);
    }
}

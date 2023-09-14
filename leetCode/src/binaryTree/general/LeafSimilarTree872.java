package binaryTree.general;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leavesList1 = new ArrayList<>();
        List<Integer> leavesList2 = new ArrayList<>();
        dfs(root1, leavesList1);
        dfs(root2, leavesList2);
        return leavesList1.equals(leavesList2);

    }

    private void dfs(TreeNode root, List<Integer> list){
        if (root != null ){
            if ( root.left == null && root.right == null)
                list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}

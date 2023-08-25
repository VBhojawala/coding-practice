package binaryTree.general;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {

    List<List<Integer>> result;
    List<Integer> temp;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(root, targetSum);
        return result;
    }

    public void dfs(TreeNode root, int sum){
        if (root == null)
            return;

        sum -= root.val;

        temp.add(root.val);
        if (sum == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(temp));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        temp.remove(temp.size() -1);
    }

    public static void main(String[] args) {

    }
}

package binaryTree.general;

import binaryTree.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator173 {

    private List<Integer> values ;
    private Iterator<Integer> iterator;

    public BSTIterator173(TreeNode root) {
        values= new LinkedList<>();
        fillInorder(root);
        iterator = values.iterator();
    }

    public int next() {
        return  iterator.next();
    }

    public boolean hasNext() {
        return  iterator.hasNext();
    }

    private void fillInorder(TreeNode root){
        if(root != null){
            fillInorder(root.left);
            values.add(root.val);
            fillInorder(root.right);
        }
    }

}

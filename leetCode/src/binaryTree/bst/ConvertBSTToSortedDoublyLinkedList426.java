package binaryTree.bst;

import binaryTree.general.Node;

public class ConvertBSTToSortedDoublyLinkedList426 {

    private Node head = null, tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    private void dfs(Node node){
        if (node == null) return;
        dfs(node.left);
        if (tail != null){
            tail.right = node;
            node.left = tail;
        }else {
            head = node;
        }
        tail = node;
        dfs(node.right);

    }
}

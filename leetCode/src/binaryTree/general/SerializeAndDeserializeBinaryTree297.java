package binaryTree.general;

import binaryTree.TreeNode;
import com.sun.source.tree.Tree;

public class SerializeAndDeserializeBinaryTree297 {

    StringBuilder preOrderBuilder;
    String[] preOrder;
    int preIndex;
    public String serialize(TreeNode root) {
        preOrderBuilder = new StringBuilder();
        buildPreOrder(root);
        preOrderBuilder.deleteCharAt(preOrderBuilder.length()-1);
        return preOrderBuilder.toString();
    }

    private void buildPreOrder(TreeNode root){
        if (root==null){
            preOrderBuilder.append("N,");
            return;
        }
        preOrderBuilder.append(root.val+",");
        buildPreOrder(root.left);
        buildPreOrder(root.right);
    }

    public TreeNode deserialize(String data) {
        preOrder = data.split(",");
        preIndex = 0;
        return buildTree();
    }

    private TreeNode buildTree(){
        if (preOrder[preIndex].equals("N")){
            preIndex++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(preOrder[preIndex++]));
        node.left = buildTree();
        node.right = buildTree();

        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        SerializeAndDeserializeBinaryTree297 prog = new SerializeAndDeserializeBinaryTree297();
        String serialized = prog.serialize(node1);
        System.out.println(serialized);
        TreeNode root = prog.deserialize(serialized);
        System.out.println(root);
    }
}

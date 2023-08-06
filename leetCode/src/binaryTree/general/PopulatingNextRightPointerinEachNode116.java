package binaryTree.general;

public class PopulatingNextRightPointerinEachNode116 {
    public Node connect(Node root) {
        Node cur = root;
        Node nxt = root == null ? null : root.left;

        while (cur != null && nxt != null){
            cur.left.next = cur.right;
            if(cur.next != null){
                cur.right.next = cur.next.left;
            }
            cur = cur.next;
            if (cur == null){
                cur = nxt;
                nxt = cur.left;
            }
        }
        return root;
    }
}

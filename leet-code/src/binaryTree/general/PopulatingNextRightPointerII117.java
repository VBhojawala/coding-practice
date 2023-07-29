package binaryTree.general;

public class PopulatingNextRightPointerII117 {
    public Node connect(Node root) {
       if(root == null)
           return root;

       Node cur = root;
       Node dummyNext = new Node(0);
       Node nxt = dummyNext;

       while (cur != null){
           if(cur.left != null){
                nxt.next = cur.left;
                nxt = nxt.next;
           }
           if(cur.right !=null){
               nxt.next = cur.right;
               nxt = nxt.next;
           }
           if(cur.next != null){
               cur = cur.next;
           }else {
               cur = dummyNext.next;
               dummyNext.next = null;
               nxt = dummyNext;
           }
       }
        return root;
    }
}

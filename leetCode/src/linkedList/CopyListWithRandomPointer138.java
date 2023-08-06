package linkedList;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node copy = dummy;

        Map<Node, Node> nodeMap = new HashMap<>();

        for(Node curr = head; curr != null; curr = curr.next){
            copy.next = new Node(curr.val);
            copy = copy.next;
            nodeMap.put(curr, copy);
        }

        copy = dummy.next;
        for (Node curr =head; curr != null; curr = curr.next){
            copy.random = nodeMap.get(curr.random);
            copy = copy.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

    }
}

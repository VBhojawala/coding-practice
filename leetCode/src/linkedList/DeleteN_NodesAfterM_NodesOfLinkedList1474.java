package linkedList;

public class DeleteN_NodesAfterM_NodesOfLinkedList1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (prev != null){
            for (int i=0; i < m && prev != null; i++)
                prev = prev.next;

            if (prev == null) break;

            ListNode curr = prev.next;

            for (int i=0; i<n && curr != null; i++)
                curr = curr.next;

            prev.next = curr;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2; node2.next = node3;
        node3.next = node4; node4.next = node5;
        node5.next = node6; node6.next = node7;

        DeleteN_NodesAfterM_NodesOfLinkedList1474 prog = new DeleteN_NodesAfterM_NodesOfLinkedList1474();
        System.out.println(prog.deleteNodes(node1, 2,3));

    }
}

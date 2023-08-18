package linkedList;


public class ReverseNodesInKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy,curr = dummy;

        while (curr.next != null){

            for (int i=0; i <k && curr != null; i++ )
                curr = curr.next;
            if (curr == null)
                break;

            ListNode next = curr.next;

            curr.next = null;
            ListNode start = prev.next;

            prev.next = reverseLinkedList(start);
            start.next = next;

            prev = start;
            curr = start;
        }

        return dummy.next;
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null ,curr= head, next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        return prev;
    }
}

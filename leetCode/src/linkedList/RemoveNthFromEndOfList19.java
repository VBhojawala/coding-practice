package linkedList;

public class RemoveNthFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left=dummy, right=head;

        for (int i=0; i <n; i ++){
            right = right.next;
        }

        while (right !=null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }
}

package linkedList;

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy, curr= head;

        for (int i=0; i < left-1; i++){
            leftPrev = curr;
            curr = curr.next;
        }

        ListNode prev =null;
        for (int i=0; i < right -left + 1; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;

    }
}

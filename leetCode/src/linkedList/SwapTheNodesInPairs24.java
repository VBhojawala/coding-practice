package linkedList;

public class SwapTheNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy,curr = head, temp;

        while (curr != null && curr.next != null){
            temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            prev.next = temp;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}

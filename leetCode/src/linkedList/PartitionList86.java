package linkedList;

public class PartitionList86 {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode lTail = left, rTail = right;

        ListNode curr = head;

        while (curr != null){
            if(curr.val < x){
                lTail.next = curr;
                lTail = lTail.next;
            }else {
                rTail.next = curr;
                rTail = rTail.next;
            }
            curr = curr.next;
        }
        rTail.next = null;
        lTail.next = right.next;

        return left.next;

    }

}

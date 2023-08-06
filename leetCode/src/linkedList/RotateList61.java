package linkedList;

public class RotateList61   {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;

        int len=1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        k = k % len;

        if (k==0)
            return head;

        ListNode curr = head;
        for (int i=0; i < len - k -1 ; i ++){
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }
}

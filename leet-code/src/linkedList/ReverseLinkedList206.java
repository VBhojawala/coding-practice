package linkedList;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null, curr = head;
        ListNode next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return  prev;

    }
    public ListNode reverseListRecursive (ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;

    }

    public static void main(String[] args) {

    }
}

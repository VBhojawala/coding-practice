package linkedList;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode oddList = head, evenList = head.next;
        ListNode evenListHead = evenList;

        while (evenList != null && evenList.next != null){
            oddList.next = evenList.next;
            oddList = oddList.next;
            evenList.next = oddList.next;
            evenList = evenList.next;
        }

        oddList.next = evenListHead;
        return head;
    }
}

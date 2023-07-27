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
    public static void main(String[] args) {

    }
}

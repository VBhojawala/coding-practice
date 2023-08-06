package linkedList;

public class RemoveDuplicatesFromSortedListII82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;

        while(curr !=null){
            while (curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(prev.next == curr){
                prev = curr;
            }else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

package divideAndConquer;

public class SortedList148 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next==null)
            return head;

        ListNode slow = head, fast= head.next;

        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (left != null && right != null){
            if (left.val <= right.val){
                curr.next = left;
                left = left.next;
            }
            else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right: left;
        return dummy.next;
    }
}

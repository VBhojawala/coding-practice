package linkedList;



public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0, sum;

        while(l1 != null || l2 != null || carry != 0){

            sum = (l1 == null ? 0 : l1.val) + ( l2 == null ? 0: l2.val) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

        }

        return result.next;

    }

}

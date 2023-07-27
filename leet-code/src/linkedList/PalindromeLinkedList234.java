package linkedList;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow= head, fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null , curr = slow;

        while (curr !=null){
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        ListNode left = head, right= prev;

        while (right != null){
            if(left.val != right.val)
                return false;
            right = right.next;
            left = left.next;
        }
        return true;


    }
}

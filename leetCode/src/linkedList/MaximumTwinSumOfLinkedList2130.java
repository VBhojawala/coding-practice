package linkedList;

public class MaximumTwinSumOfLinkedList2130 {
    public int pairSum(ListNode head) {
        ListNode slow= head, fast= head.next;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstList = head;
        ListNode secondList = slow.next;
        slow.next = null;
        secondList = reverseLinkedList(secondList);
        
        int max=0;
        while (firstList != null){
            max = Math.max(max, firstList.val+secondList.val);
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return max;
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null, next;
        ListNode curr = head;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        MaximumTwinSumOfLinkedList2130 prog = new MaximumTwinSumOfLinkedList2130();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2; node2.next = node3;
        node3.next = node4;

        System.out.println(prog.pairSum(node1));;
        System.out.println(node1);

    }
}

package linkedList;

import binaryTree.general.Node;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        ListNode slow= head, fast=head.next;

        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow.next;
        ListNode pre = null, next=null;
        slow.next = null;

        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }


        ListNode list1 = head, list2 = pre;
        ListNode temp1, temp2;

        while (list2 != null){
            temp1 = list1.next;
            temp2 = list2.next;
            list1.next = list2;
            list2.next = temp1;
            list1 = temp1;
            list2 = temp2;
        }

    }

    public static void main(String[] args) {
        ReorderList143 prog = new ReorderList143();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2; node2.next = node3;
        node3.next = node4;

        prog.reorderList(node1);
        System.out.println(node1);

    }
}

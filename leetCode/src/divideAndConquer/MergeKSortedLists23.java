package divideAndConquer;

import java.util.List;

public class MergeKSortedLists23 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  ListNode[] lists;
    public ListNode mergeKLists(ListNode[] lists) {

      if (lists.length == 0)
          return null;

      this.lists = lists;
      return mergeSort(0, lists.length-1);

    }

    public ListNode mergeSort(int left ,int right){
        if (right <= left) return lists[left];
        int mid = left + (right -left) / 2;

        ListNode leftSorted = mergeSort(left, mid);
        ListNode rightSorted = mergeSort(mid+1, right);

        return merge(leftSorted, rightSorted);
    }

    public  ListNode merge(ListNode l1, ListNode l2){
      ListNode dummy = new ListNode();
      ListNode curr = dummy;

      while (l1 != null && l2 != null){
        if(l1.val <= l2.val){
          curr.next = l1;
          l1= l1.next;
        }
        else {
          curr.next = l2;
          l2 = l2.next;
        }
        curr = curr.next;
      }

      curr.next = l1 == null ? l2 : l1;
      return dummy.next;

    }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next= new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);



    ListNode[] lists = new ListNode[]{l1,l2,l3};

    MergeKSortedLists23 prog = new MergeKSortedLists23();
    ListNode result = prog.mergeKLists(lists);
    System.out.println(result);

  }
}

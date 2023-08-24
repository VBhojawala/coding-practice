package heap;

import java.util.PriorityQueue;

public class KthLargetElementInStream703 {

    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargetElementInStream703(int k, int[] nums) {
        minHeap  = new PriorityQueue<>();
        this.k = k;
        for (int num : nums)
           add(num);
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargetElementInStream703 prog = new KthLargetElementInStream703(3, new int[]{4, 5, 8, 2});
        System.out.println(prog.add(3));
        System.out.println(prog.add(5));
        System.out.println(prog.add(10));
        System.out.println(prog.add(9));
        System.out.println(prog.add(4));

    }
}

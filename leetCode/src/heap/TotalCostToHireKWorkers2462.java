package heap;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        for (int i=0;i< candidates;i++)
            leftHeap.offer(costs[i]);

        for (int i= Math.max(candidates, n- candidates); i<n; i++)
            rightHeap.offer(costs[i]);

        long minCost =0;
        int left = candidates, right = n-1-candidates;

        for (int i=0;i<k;i++){
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() &&  leftHeap.peek() <= rightHeap.peek())){
                minCost += leftHeap.poll();
                if (left <= right)
                    leftHeap.offer(costs[left++]);
            }else {
                minCost += rightHeap.poll();
                if (left <= right)
                    rightHeap.offer(costs[right--]);
            }
        }

        return minCost;
    }
}

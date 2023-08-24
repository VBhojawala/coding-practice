package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s: stones)
            maxHeap.add(s);

        int x,y;
        while (maxHeap.size() >1){
            y = maxHeap.poll();
            x = maxHeap.poll();
            if (x != y)
                maxHeap.offer(y-x);
        }
        return maxHeap.isEmpty() ? 0: maxHeap.poll();
    }
}

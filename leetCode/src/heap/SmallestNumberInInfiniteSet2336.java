package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestNumberInInfiniteSet2336 {

    private PriorityQueue<Integer> pq;
    private Set<Integer> set;
    public SmallestNumberInInfiniteSet2336() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        for (int i=1;i<1010;i++){
            pq.offer(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        int s = pq.poll();
        set.remove(s);
        return s;
    }

    public void addBack(int num) {
        if (!set.contains(num)){
            set.add(num);
            pq.offer(num);
        }
    }
}

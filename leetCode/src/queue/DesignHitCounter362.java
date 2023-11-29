package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter362 {
    private Queue<Integer> queue;
    public DesignHitCounter362() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && (timestamp - queue.peek()) >= 300){
            queue.poll();
        }
        return queue.size();
    }
}

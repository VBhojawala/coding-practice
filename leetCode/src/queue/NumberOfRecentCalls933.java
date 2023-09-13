package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls933 {

    private Deque<Integer> queue;
    public NumberOfRecentCalls933() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peekFirst() < t - 3000)
            queue.pollFirst();
        return queue.size();
    }
}

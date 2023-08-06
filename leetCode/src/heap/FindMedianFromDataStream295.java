package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;
    public FindMedianFromDataStream295() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minPQ.offer(num);
        maxPQ.offer(minPQ.poll());

        if(maxPQ.size() - minPQ.size() > 1){
            minPQ.offer(maxPQ.poll());
        }
    }

    public double findMedian() {
        if (maxPQ.size() > minPQ.size())
            return maxPQ.peek();
        return (minPQ.peek() + maxPQ.peek())  / 2.0 ;
    }

    public static void main(String[] args) {
        int[] arr = {2,3, 4};

        FindMedianFromDataStream295 median = new FindMedianFromDataStream295();

        Arrays.stream(arr).forEach((median::addNum));

        System.out.println(median.findMedian());
    }
}

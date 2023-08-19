package interval;

import java.util.*;
import java.util.stream.IntStream;

public class MinimumIntervalToIncludeEachQuery1851 {

    public static class Interval {
        int length;
        int right;

        public Interval(int length, int right) {
            this.length = length;
            this.right = right;
        }
    }
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n= intervals.length, m= queries.length;
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i.length));

        int i=0, left, right;

        for (int q : IntStream.of(queries).sorted().toArray()){

            while (i < n && intervals[i][0] <= q){
                left = intervals[i][0];
                right = intervals[i][1];
                minHeap.offer(new Interval(right-left+1, right));
                i++;
            }

            while ( !minHeap.isEmpty() && minHeap.peek().right < q){
                minHeap.poll();
            }

            if (!minHeap.isEmpty()){
                result.put(q, minHeap.peek().length);
            }else {
                result.put(q, -1);
            }
        }

        int[] resultArray = new int[m];
        for (int j=0;j<m;j++){
            resultArray[j] = result.get(queries[j]);
        }
        return  resultArray;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{2,4},{3,6},{4,4}};
        int[] queries = new int[]{2,3,4,5};

        MinimumIntervalToIncludeEachQuery1851 prog = new MinimumIntervalToIncludeEachQuery1851();
//        Arrays.stream(prog.minInterval(intervals, queries)).forEach(System.out::println);

        intervals = new int[][]{{2,3},{2,5},{1,8},{20,25}};
        queries = new int[]{2,19,5,22};
        Arrays.stream(prog.minInterval(intervals, queries)).forEach(System.out::println);

    }
}

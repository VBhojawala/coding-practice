package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for (int point[] : points)
            minHeap.offer(new int[]{point[0]* point[0] + point[1]*point[1], point[0], point[1]});
        int[][] result = new int[k][2];
        for (int i=0; i<k;i++){
            int[] point = minHeap.poll();
            result[i][0] = point[1];
            result[i][1] = point[2];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{3,3},{5,-1},{-2,4}};
        KClosestPointsToOrigin973 prog = new KClosestPointsToOrigin973();
        Arrays.stream(prog.kClosest(points, 2)).forEach(e-> Arrays.stream(e).forEach(System.out::println));
    }
}

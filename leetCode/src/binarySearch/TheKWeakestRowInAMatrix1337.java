package binarySearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowInAMatrix1337 {

    private int[][] mat;
    private int m, n;
    public int[] kWeakestRows(int[][] mat, int k) {
        this.mat = mat;
        m = mat.length; n = mat[0].length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for (int row =0; row < m; row++){
            int solderCount = binarySearch(row);
            heap.offer(new int[]{row, solderCount});
            if (heap.size() > k)
                heap.poll();
        }

        int[] weakestRowIndexes = new int[k];

        for (int i=k-1; i > -1; i--){
            weakestRowIndexes[i] = heap.poll()[0];
        }

        return weakestRowIndexes;

    }

    private int binarySearch(int row){
        int left = 0, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mat[row][mid] == 1)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

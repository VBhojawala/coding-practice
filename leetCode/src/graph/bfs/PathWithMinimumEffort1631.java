package graph.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] diff = new int[m][n];

        for (int i=0; i<m; i++)
            Arrays.fill(diff[i], Integer.MAX_VALUE);

        diff[0][0] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.offer(new int[]{0,0,0});

        int[][] dirs = new int[][] {{-1,0}, {0,1}, {1,0}, {0,-1}};

        while (!heap.isEmpty()){
            var cur = heap.poll();
            int d = cur[0], i = cur[1], j = cur[2];
            for (var dir : dirs){
                int x = i + dir[0], y = j + dir[1];
                if (x > -1 && y > -1 && x < m && y < n){
                    int pathDiff = Math.max(d, Math.abs(heights[i][j] - heights[x][y]));
                    if (pathDiff < diff[x][y]){
                        diff[x][y] = pathDiff;
                        heap.offer(new int[]{pathDiff, x, y});
                    }
                }
            }
        }

        return diff[m-1][n-1];
    }
}

package graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestBridge934 {

    private int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    private Deque<int[]> queue = new ArrayDeque<>();
    private int[][] grid;
    private int n, x,y;
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        boolean isFound = false;
        for (int i=0; i<n && !isFound; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    isFound= true;
                    dfs(i,j);
                    break;
                }
            }
        }

        int distance = 0;
        int[] curr;
        while (true){
            for (int i=queue.size(); i> 0; i--){
                curr = queue.poll();
                for (int[] dir : dirs){
                    x = curr[0] + dir[0];
                    y = curr[1] +dir[1];
                    if (x >=0 && y >=0 && x < n && y < n){
                        if (grid[x][y] == 1)
                            return distance;
                        if (grid[x][y] == 0){
                            grid[x][y] = 2;
                            queue.add(new int[]{x,y});

                        }
                    }
                }
            }
            distance++;
        }
    }

    private void dfs(int i, int j){
        grid[i][j] =2;
        queue.offer(new int[]{i,j});
        for (int[] dir : dirs){
            x = i+ dir[0];
            y = j + dir[1];
            if (x >=0 && y >=0 && x < n && y < n && grid[x][y] == 1)
                dfs(x,y);
        }
    }
}

package graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class NearestExitFromEntranceInMaze1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m= maze.length, n= maze[0].length, count =0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int[][] dir = new int[][]{{0,1},{1,0}, {0,-1},{-1,0}};
        int x,y;
        while (!queue.isEmpty()){
            count++;
            for (int k = queue.size(); k>0; k--){
                int[] pos = queue.poll();
                for (int[] d : dir){
                    x = pos[0] + d[0]; y= pos[1] + d[1];
                    if (x >=0 && y >=0 && x <m && y<n && maze[x][y] == '.'){
                        if (x==0 || y==0 || x == m-1 || y == n-1) return count;
                        queue.offer(new int[]{x,y});
                        maze[x][y] = '+';
                    }
                }
            }
        }
        return -1;
    }
}

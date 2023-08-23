package graph.general;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length, count=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == 1)
                    count++;
                else if (grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
            }
        }

        int time=0,x,y;
        int[][] rc = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty() && count >0){
            time++;
            for(int i=queue.size(); i>0;i--){
                int[] cur = queue.poll();

                for (int[] crc : rc){
                    x = cur[0] + crc[0];
                    y = cur[1] + crc[1];

                    if (x>=0 && y>=0 && x<m && y<n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        count--;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }

        return count == 0 ? time : -1;
    }

    public static void main(String[] args) {
        RottingOranges994 prog = new RottingOranges994();
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(prog.orangesRotting(grid));
        System.out.println(prog.orangesRotting(new int[][]{{0,2}}));
        System.out.println(prog.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
    }
}

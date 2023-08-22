package graph.general;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater778 {

    public class Edge{
        int time;
        int row;
        int col;

        public Edge(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    int n;
    Set<Integer> visited;
    PriorityQueue<Edge> minHeap;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        visited = new HashSet<>();
        minHeap = new PriorityQueue<>(Comparator.comparingInt(e->e.time));
        minHeap.offer(new Edge(grid[0][0],0,0));
        visited.add(0);

        int[][] rc = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
        while (!minHeap.isEmpty()){
            Edge e = minHeap.poll();

            if (e.row == n-1 && e.col ==n-1)
                return e.time;

            for (int[] cc: rc){
                int r = e.row + cc[0];
                int c = e.col + cc[1];
                if (r < n && r >=0 && c <n && c>=0 && !visited.contains(r*n+c%n)){
                    visited.add(r*n+c%n);
                    minHeap.offer(new Edge(Math.max(e.time, grid[r][c]), r, c));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater778 prog = new SwimInRisingWater778();
        int[][] grid = new int[][] {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(prog.swimInWater(grid));;
        grid = new int[][]{{0,2},{1,3}};
        System.out.println(prog.swimInWater(grid));
    }
}

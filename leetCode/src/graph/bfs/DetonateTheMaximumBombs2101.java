package graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DetonateTheMaximumBombs2101 {

    private int[][] bombs;
    private long x, y, r;
    public int maximumDetonation(int[][] bombs) {
        this.bombs = bombs;
        int n = bombs.length;
        boolean[][] graph = new boolean[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                graph[i][j] = isConnected(i,j);
            }
        }

        int max = 0, v, count;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for (int p=0; p<n; p++){
            queue.clear();
            queue.offer(p);

            Arrays.fill(visited, false);
            visited[p] = true;
            count =0;

            while (!queue.isEmpty()){
                v = queue.poll();
                count++;

                for (int j=0; j<n;j++){
                    if (graph[v][j] && !visited[j]){
                        queue.offer(j);
                        visited[j] = true;
                    }
                }

            }

            max = Math.max(max, count);

        }

        return max;

    }

    private boolean isConnected(int i, int j){
        if (i == j) return false;
        x = bombs[i][0] - bombs[j][0];
        y = bombs[i][1] - bombs[j][1];
        r = bombs[i][2];
        return r*r >= x*x + y*y;
    }

    public static void main(String[] args) {
        DetonateTheMaximumBombs2101 prog = new DetonateTheMaximumBombs2101();
        int[][] bombs = new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println(prog.maximumDetonation(bombs));
    }
}

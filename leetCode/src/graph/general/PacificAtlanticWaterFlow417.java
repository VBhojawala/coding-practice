package graph.general;

import java.util.*;

public class PacificAtlanticWaterFlow417 {


    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        Set<Integer> pSet = new HashSet<>();
        Set<Integer> aSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pQueue.offer(new int[]{i, j});
                    pSet.add(i * n + j);
                }
                if (i == m - 1 || j == n - 1) {
                    aQueue.offer(new int[]{i, j});
                    aSet.add(i * n + j);
                }
            }
        }

        bfs(pQueue, pSet);
        bfs(aQueue, aSet);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (aSet.contains(i * n + j) && pSet.contains(i * n + j)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(Queue<int[]> queue, Set<Integer> visited) {

        int[][] rc = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int x, y;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] cc : rc) {
                x = cc[0] + cur[0];
                y = cc[1] + cur[1];

                if (x >= 0 && y >= 0 && x < m && y < n && !visited.contains(x * n + y)
                        &&   heights[x][y] >= heights[cur[0]][cur[1]]) {
                    visited.add(x * n + y);
                    queue.offer(new int[]{x, y});
                }
            }

        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow417 prog = new PacificAtlanticWaterFlow417();
        int[][] heights = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(prog.pacificAtlantic(heights));
    }
}
package matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Matrix01_542 {
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length, n=mat[0].length;
        int[][] result = new int[m][n];

        for (var row: result)
            Arrays.fill(row, -1);

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (mat[i][j] == 0){
                    queue.offer(new int[] {i,j});
                    result[i][j] = 0;
                }
            }
        }

        int[][] dirs = new int[][] {{-1,0}, {0,1},{1,0}, {0,-1}};

        while (!queue.isEmpty()){
            var curCell = queue.poll();
            for (var dir: dirs){
                int x = curCell[0] + dir[0];
                int y = curCell[1] + dir[1];

                if (x > -1 && y > -1 && x < m && y < n && result[x][y] == -1){
                    result[x][y] = result[curCell[0]][curCell[1]] + 1;
                    queue.offer(new int[]{x,y});
                }
            }
        }

        return result;
    }
}

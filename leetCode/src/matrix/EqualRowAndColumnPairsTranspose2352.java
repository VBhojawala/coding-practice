package matrix;

import java.util.Arrays;

public class EqualRowAndColumnPairsTranspose2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;
        int[][] cGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cGrid[j][i] = grid[i][j];
            }
        }

        for (int row[] : grid){
            for (int col[] : cGrid){
                if (Arrays.equals(row, col))
                    count++;
            }
        }

        return count;
    }
}

package dynamicProgramming.twoDimensional;

import java.util.Arrays;

public class MinimumPathSum1D64 {
    public int minPathSum(int[][] grid) {
        int m= grid.length, n= grid[0].length;

        for (int i=1; i< m; i ++)
            grid[i][0] += grid[i-1][0];

        for (int j=1; j<n; j++)
            grid[0][j] += grid[0][j-1];

        for (int i= 1; i< m; i ++){
            for (int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        MinimumPathSum1D64 prog = new MinimumPathSum1D64();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(prog.minPathSum(grid));
    }
}

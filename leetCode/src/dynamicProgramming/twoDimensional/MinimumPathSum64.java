package dynamicProgramming.twoDimensional;

import java.util.Arrays;

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        int rows= grid.length, cols= grid[0].length;
        int[][] dp = new int[rows+1][cols+1];
        Arrays.stream(dp).forEach(row-> Arrays.fill(row, Integer.MAX_VALUE));;

        dp[rows][cols-1] = 0;

        for (int i=rows-1; i >=0 ; i--){
            for (int j=cols-1; j>=0; j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumPathSum64 prog = new MinimumPathSum64();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(prog.minPathSum(grid));
    }
}

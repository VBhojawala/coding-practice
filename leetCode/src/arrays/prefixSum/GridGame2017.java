package arrays.prefixSum;

public class GridGame2017 {

    public long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE;
        long s1 = 0, s2 = 0;

        for (int s : grid[0])
            s1 += s;

        for (int j=0; j<grid[0].length; j++){
            s1 -= grid[0][j];
            result = Math.min(result, Math.max(s1, s2));
            s2 += grid[1][j];
        }

        return  result;
    }
}

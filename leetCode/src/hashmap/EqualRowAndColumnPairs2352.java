package hashmap;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs2352 {
    private static final int PRIME = 29;
    int[][] grid;
    int n;
    public int equalPairs(int[][] grid) {
        this.n=grid.length;
        this.grid = grid;
        int count=0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<n;i++)
            map.merge(getRowHash(i), 1, Integer::sum);

        for (int i=0;i<n;i++)
            count += map.getOrDefault(getColHash(i), 0);

        return count;
    }

    private int getRowHash(int row){
        int hash = PRIME;
        for (int i=0;i<n;i++){
            hash = hash * PRIME + grid[row][i];
        }
        return hash;
    }

    private int getColHash(int col){
        int hash = PRIME;
        for (int i=0;i<n;i++){
            hash = hash * PRIME + grid[i][col];
        }
        return hash;
    }

}

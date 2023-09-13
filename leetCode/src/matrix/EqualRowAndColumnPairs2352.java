package matrix;

public class EqualRowAndColumnPairs2352 {
    public int equalPairs(int[][] grid) {
        int n=grid.length, count=0;
        boolean isSame;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                isSame = true;
                for (int k=0; k<n;k++){
                    if (grid[i][k] != grid[k][j]){
                        isSame = false;
                        break;
                    }
                }
                if (isSame)
                    count++;
            }
        }
        return count;
    }
}

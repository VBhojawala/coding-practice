package graph.general;

public class FloodFill733 {
    private int m,n;
    private int oldColor, newColor;
    private int[][] image;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image ; m = image.length; n = image[0].length;
        oldColor = image[sr][sc]; newColor = color;
        if(newColor != oldColor) dfs(sr,sc);
        return image;
    }

    private void dfs(int row, int col){
        if (image[row][col] == oldColor){
            image[row][col] = newColor;
            if (row > 0 ) dfs(row-1, col);
            if (col > 0) dfs(row, col-1);
            if (row+1 < m) dfs(row+1, col);
            if (col+1 < n) dfs(row, col+1);
        }
    }
}

package graph.general;

public class NumberOfClosedIsland1254 {

    private int m,n,x,y;
    private int[][] grid;
    private boolean[][] visited;
    private int[][] dirs = new int[][]{{-1,0},{0, 1}, {1,0}, {0,-1}};
    public int closedIsland(int[][] grid) {
        m= grid.length; n= grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        int count =0;

        for(int i=0; i<m ; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 0 && !visited[i][j] && dfs(i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j){

        if (i < 0 || j < 0 || i >=m || j >=n)
            return false;
        if (grid[i][j] == 1 || visited[i][j])
            return true;

        visited[i][j] = true;
        boolean isClosed = true;

        for (int[] dir: dirs){
            x = i + dir[0];
            y = j + dir[1];
            if (!dfs(x,y))
                isClosed = false;
        }

        return isClosed;
    }
}
